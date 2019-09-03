package com.geopark.framework.image;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 图片工具类
 * 
 * @author lichee
 */
@Slf4j
@Service
public class ImageScale {

	public static int generateCount = 0;
	@Value("${geopark.photo.contentType}")
	public String contentType;
	private static final String ERROR_MSG = "文件处理出错...";
	
	/**
	 * 根据图片大小裁剪 
	 */
	public boolean cropImage(BufferedImage buffer, ImageSize imageSize, File saveFile) {
		
		int height;
		if(buffer.getWidth()>buffer.getHeight()){
			height = buffer.getHeight();
		}else {
			height = buffer.getWidth();
		}
		// 从放大的图像中心截图
		buffer = buffer.getSubimage((buffer.getWidth() - height) / 2, (buffer.getHeight() - height) / 2,
				height, height);
		try {
			scalesImage(buffer, saveFile, new ImageSize(imageSize.getWidth(), imageSize.getHeight()));
		} catch (Exception ex) {
			log.error(ERROR_MSG);
		} finally {
			buffer.flush();
		}
		return true;
	}

	/**
	 * 图片处理
	 */
	public boolean scalesImage(BufferedImage srcBufferedImage, File destFile, ImageSize imageSize) {

		try {
			int imgWidth = imageSize.getWidth();
			int imgHeight = imageSize.getHeight();
			int srcWidth = srcBufferedImage.getWidth();
			int srcHeight = srcBufferedImage.getHeight();
			double scaleW = imageSize.getWidth() * 1.0 / srcWidth;
			double scaleH = imageSize.getHeight() * 1.0 / srcHeight;
			if (scaleW >= scaleH) {
				double imgWidth1 = scaleH * srcWidth;
				double imgHeight1 = scaleH * srcHeight;
				imgWidth = (int) imgWidth1;
				imgHeight = (int) imgHeight1;
			} else {
				double imgWidth1 = scaleW * srcWidth;
				double imgHeight1 = scaleW * srcHeight;
				imgWidth = (int) imgWidth1;
				imgHeight = (int) imgHeight1;
			}
			BufferedImage destBufferedImage = new BufferedImage(imageSize.getWidth(), imageSize.getHeight(),
					BufferedImage.TYPE_INT_RGB);
			Graphics2D graphics2D = destBufferedImage.createGraphics();
			graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			graphics2D.setBackground(Color.WHITE);
			graphics2D.clearRect(0, 0, imageSize.getWidth(), imageSize.getHeight());
			graphics2D.drawImage(srcBufferedImage.getScaledInstance(imgWidth, imgHeight, Image.SCALE_SMOOTH),
					(imageSize.getWidth() / 2) - (imgWidth / 2), (imageSize.getHeight() / 2) - (imgHeight / 2), null);
			graphics2D.dispose();
			ImageIO.write(destBufferedImage, contentType, destFile);
			return true;
		} catch (IOException e) {
			log.error(ERROR_MSG);
			return false;
		}
	}
	
	/**
	 * 图片处理
	 */
	public boolean scalesImage(BufferedImage srcBufferedImage, File destFile, String contentType,ImageSize imageSize) {

		try {
			BufferedImage destBufferedImage = new BufferedImage(imageSize.getWidth(), imageSize.getHeight(), BufferedImage.TYPE_INT_RGB); 
            Graphics2D g2d = destBufferedImage.createGraphics(); 
            destBufferedImage = g2d.getDeviceConfiguration().createCompatibleImage(imageSize.getWidth(), imageSize.getHeight(), Transparency.TRANSLUCENT); 
            g2d.dispose(); 
            g2d = destBufferedImage.createGraphics(); 
            Image from = srcBufferedImage.getScaledInstance(imageSize.getWidth(), imageSize.getHeight(), Image.SCALE_AREA_AVERAGING); 
            g2d.drawImage(from, 0, 0, null);
            g2d.dispose(); 
            ImageIO.write(destBufferedImage, contentType, destFile);
			return true;
		} catch (IOException e) {
			log.error(ERROR_MSG);
			return false;
		}
	}
	
	/**
	 * 图片处理
	 */
	public boolean scalesImage(BufferedImage srcBufferedImage, File destFile) {

		try {
			Graphics2D g = srcBufferedImage.createGraphics();
			g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g.drawImage(srcBufferedImage, 0, 0, srcBufferedImage.getWidth(), srcBufferedImage.getHeight(), null);  
			g.dispose();
			ImageIO.write(srcBufferedImage, contentType, destFile);
			return true;
		} catch (IOException e) {
			log.error(ERROR_MSG);
			return false;
		}
	}

	/**
	 * 得到不重复的图排序名字
	 * 
	 * @return 图片名称
	 */
	public String getImageName() {

		if (generateCount > 99999) {
			generateCount = 0;
		}
		String uniqueNumber = Long.toString(System.currentTimeMillis()) + Integer.toString(generateCount);
		generateCount++;
		return uniqueNumber;
	}

	/**
	 * 获取图片文件的类型.
	 * 
	 * @param imageFile
	 *            图片文件对象.
	 * @return 图片文件类型
	 */
	public String getImageFormatName(File imageFile) {

		try {
			ImageInputStream imageInputStream = ImageIO.createImageInputStream(imageFile);
			Iterator<ImageReader> iterator = ImageIO.getImageReaders(imageInputStream);
			if (!iterator.hasNext()) {
				return null;
			}
			ImageReader imageReader = (ImageReader) iterator.next();
			imageInputStream.close();
			return imageReader.getFormatName().toLowerCase();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 切割图片 
	 */
	public void thumbImage(BufferedImage bi, ImageSize imageSize, File saveFile) {
		
		// 原图片等比例缩小或放大之后的图片
		int narrowImgW;
		int narrowImgH;
		// 原图片大小
		int srcImgW;
		int srcImgH;
		try {
			srcImgW = bi.getWidth();
			srcImgH = bi.getHeight();
			// 转换图片尺寸与目标尺寸比较 ， 如果转换图片较小，说明转换图片相对于目标图片来说高较小，需要以高为基准进行缩放。
			if ((float) srcImgW / srcImgH > (float) imageSize.getWidth() / imageSize.getHeight()) {
				narrowImgW = (int) (((float) imageSize.getHeight() / (float) srcImgH) * srcImgW);
				narrowImgH = imageSize.getHeight();
				// 按照原图以高为基准等比例缩放、或放大。这一步高为所需图片的高度，宽度肯定会比目标宽度宽。
				int cutNarrowImgSize = (narrowImgW - imageSize.getWidth()) / 2;
				BufferedImage narrowImg = new BufferedImage(narrowImgW, narrowImgH, BufferedImage.TYPE_INT_RGB);
				narrowImg.getGraphics().drawImage(bi.getScaledInstance(narrowImgW, narrowImgH, Image.SCALE_SMOOTH), 0, 0, null);
				// 等比例缩放完成后宽度与目标尺寸宽度相比较 ， 将多余宽的部分分为两份 ，左边删除一部分
				Image image = narrowImg.getScaledInstance(narrowImgW, narrowImgH, Image.SCALE_DEFAULT);
				CropImageFilter cropFilter = new CropImageFilter(cutNarrowImgSize, 0, narrowImgW - cutNarrowImgSize, narrowImgH);
				Image img = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), cropFilter));
				BufferedImage cutLiftNarrowImg = new BufferedImage(narrowImgW - cutNarrowImgSize, narrowImgH, BufferedImage.TYPE_INT_RGB);
				cutLiftNarrowImg.getGraphics().drawImage(img, 0, 0, null);
				// 右边删除一部分
				image = cutLiftNarrowImg.getScaledInstance(narrowImgW - cutNarrowImgSize, narrowImgH, Image.SCALE_DEFAULT);
				cropFilter = new CropImageFilter(0, 0, narrowImgW - cutNarrowImgSize * 2, narrowImgH);
				img = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), cropFilter));
				BufferedImage cutRightNarrowImg = new BufferedImage(narrowImgW - cutNarrowImgSize * 2, narrowImgH, BufferedImage.TYPE_INT_RGB);
				Graphics g = cutRightNarrowImg.getGraphics();
				g.drawImage(img, 0, 0, null); // 绘制截取后的图
				g.dispose();
				// 输出为文件 最终为所需要的格式
				ImageIO.write(cutRightNarrowImg, contentType, saveFile);
			} else { // 以宽度为基准
				narrowImgW = imageSize.getWidth();
				narrowImgH = (int) (((float) imageSize.getWidth() / (float) srcImgW) * srcImgH);
				int cutNarrowImgSize = (narrowImgH - imageSize.getHeight()) / 2;
				BufferedImage narrowImg = new BufferedImage(narrowImgW, narrowImgH, BufferedImage.TYPE_INT_RGB);
				narrowImg.getGraphics().drawImage(bi.getScaledInstance(narrowImgW, narrowImgH, Image.SCALE_SMOOTH), 0, 0, null);

				Image image = narrowImg.getScaledInstance(narrowImgW, narrowImgH, Image.SCALE_DEFAULT);
				CropImageFilter cropFilter = new CropImageFilter(0, cutNarrowImgSize, narrowImgW, narrowImgH - cutNarrowImgSize);
				Image img = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), cropFilter));
				BufferedImage cutTopNarrowImg = new BufferedImage(narrowImgW, narrowImgH - cutNarrowImgSize, BufferedImage.TYPE_INT_RGB);
				cutTopNarrowImg.getGraphics().drawImage(img, 0, 0, null);
				image = cutTopNarrowImg.getScaledInstance(narrowImgW, narrowImgH - cutNarrowImgSize, Image.SCALE_DEFAULT);
				cropFilter = new CropImageFilter(0, 0, narrowImgW, narrowImgH - cutNarrowImgSize * 2);
				img = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), cropFilter));
				BufferedImage cutBottomNarrowImg = new BufferedImage(narrowImgW, narrowImgH - cutNarrowImgSize * 2, BufferedImage.TYPE_INT_RGB);
				Graphics g = cutBottomNarrowImg.getGraphics();
				g.drawImage(img, 0, 0, null);
				g.dispose();
				ImageIO.write(cutBottomNarrowImg, contentType, saveFile);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}