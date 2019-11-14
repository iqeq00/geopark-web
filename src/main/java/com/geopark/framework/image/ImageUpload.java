package com.geopark.framework.image;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 图片上传组件工具类
 * 
 * @author lichee
 */
@Slf4j
@Service
public class ImageUpload {

	@Autowired
	private ImageScale imageScale;
	@Autowired
	private ImageSizeFactory imageSizeFactory;

	private static final String ERROR_MSG = "上传图片文件出错...";

	public File mkDirs(String fileFolder) {

		File savedir = new File(fileFolder);
		if (!savedir.exists()) {
			savedir.mkdirs();
		}
		return savedir;
	}

	/**
	 * 图片上传 one file(原图)
	 * 
	 * @param fileFolder
	 *            fileFolder 上传的路径
	 * @param file
	 *            file multipartFile对象
	 * @return String 上传后的文件名
	 */
	public String imageUploadType(String fileFolder, MultipartFile file, String contentType) {

		try {
			String fileName = null;
			if (!file.isEmpty()) {
				File savedir = mkDirs(fileFolder);
				fileName = imageScale.getImageName() + "." + contentType;
				File saveFile = new File(savedir, fileName);
				FileUtils.copyInputStreamToFile(file.getInputStream(), saveFile);
			}
			return fileName;
		} catch (IOException e) {
			log.error(ERROR_MSG);
			return null;
		}
	}

	/**
	 * 图片上传 one file(原图)
	 * 
	 * @param fileFolder
	 *            fileFolder 上传的路径
	 * @param file
	 *            file multipartFile对象
	 * @return String 上传后的文件名
	 */
	public String imageUpload(String fileFolder, MultipartFile file) {

		try {
			String fileName = null;
			if (!file.isEmpty()) {
				File savedir = mkDirs(fileFolder);
//				fileName = imageScale.getImageName() + "-" + file.getOriginalFilename().substring(0,file.getOriginalFilename().lastIndexOf(".")) + "." + imageScale.contentType;
				fileName = imageScale.getImageName() + "-" + file.getOriginalFilename();
				File saveFile = new File(savedir, fileName);
				FileUtils.copyInputStreamToFile(file.getInputStream(), saveFile);
			}
			return fileName;
		} catch (IOException e) {
			log.error(ERROR_MSG);
			return null;
		}
	}

	/**
	 * 风化
	 *
	 * @param fileFolder
	 * @param file
	 * @param limit
	 * @return
	 */
	public String imageUploadAndCompress(String fileFolder, MultipartFile file, long limit, float qulitity) {

		try {
			String fileName = null;
			if (!file.isEmpty()) {
				File savedir = mkDirs(fileFolder);
				fileName = imageScale.getImageName() + "." + imageScale.contentType;
				File saveFile = new File(savedir, fileName);
				FileUtils.copyInputStreamToFile(file.getInputStream(), saveFile);
				if (file.getSize() > limit) {
					Thumbnails.of(saveFile).scale(1.0f).outputQuality(qulitity).toFile(saveFile);
				}
			}
			return fileName;
		} catch (IOException e) {
			log.error(ERROR_MSG);
			return null;
		}
	}

	private String imageUpload(String fileFolder, MultipartFile file, List<ImageSize> list) {

		try {
			String fileName = null;
			if (!file.isEmpty()) {
				File savedir = mkDirs(fileFolder);
				Image src = Toolkit.getDefaultToolkit().createImage(file.getBytes());
				BufferedImage image = toBufferedImage(src);
				fileName = imageUpload(fileFolder, file);
				for (int j = 1; j <= list.size(); j++) {
					ImageSize imageSize = list.get(j - 1);
					String imageName = j + fileName;
					File saveFile = new File(savedir, imageName);
					imageScale.scalesImage(image, saveFile, imageSize);
				}
				if (list.size() == 1) {
					fileName = 1 + fileName;
				}
			}
			return fileName;
		} catch (IOException e) {
			log.error(ERROR_MSG);
			return null;
		}
	}

	public String imageUpload(String fileFolder, MultipartFile file, ImageSize imageSize) {

		try {
			String fileName = null;
			if (!file.isEmpty()) {
				File savedir = mkDirs(fileFolder);
				Image src = Toolkit.getDefaultToolkit().createImage(file.getBytes());
				BufferedImage image = toBufferedImage(src);
				fileName = imageUpload(fileFolder, file);
				fileName = 1 + fileName;
				File saveFile = new File(savedir, fileName);
				imageScale.scalesImage(image, saveFile, imageSize);
			}
			return fileName;
		} catch (IOException e) {
			log.error(ERROR_MSG);
			return null;
		}
	}
	
	/**
	 * 图片上传 one file(切割多种尺寸)
	 * 
	 * @param fileFolder
	 *            fileFolder 上传的路径
	 * @param file
	 *            file multipartFile对象
	 * @param listStr
	 *            listStr 尺寸对象
	 * @return String 上传后的文件名
	 */
	public String imageUpload(String fileFolder, MultipartFile file, String listStr) {
		List<ImageSize> list = imageSizeFactory.getImageSizeList(listStr);
		return imageUpload(fileFolder, file, list);
	}

	/**
	 * 图片上传 many file(原图)
	 * 
	 * @param fileFolder 上传的路径
	 * @param files multipartFile集合对象
	 * @return List<String> fileNames 存放图片文件名集合
	 */
	public List<String> imageUpload(String fileFolder, List<MultipartFile> files) {

		try {
			List<String> fileNames = new ArrayList<String>();
			if (files != null) {
				for (int i = 0; i < files.size(); i++) {
					MultipartFile file = files.get(i);
					if (!file.isEmpty()) {
						String imageName = imageUpload(fileFolder, file);
						fileNames.add(i, imageName);
					}
				}
			}
			return fileNames;
		} catch (Exception e) {
			log.error(ERROR_MSG);
			return null;
		}
	}

	private List<String> imageUpload(String fileFolder, List<MultipartFile> files, List<ImageSize> list) {

		int count = 0;
		try {
			File savedir = mkDirs(fileFolder);
			List<String> fileNames = new ArrayList<String>();
			if (files != null) {
				for (int i = 0; i < files.size(); i++) {
					MultipartFile file = files.get(i);
					if (!file.isEmpty()) {
						Image src = Toolkit.getDefaultToolkit().createImage(file.getBytes());
						BufferedImage image = toBufferedImage(src);
						String imageName = imageUpload(fileFolder, file);
						fileNames.add(count++, imageName);
						for (int j = 1; j <= list.size(); j++) {
							ImageSize imageSize = list.get(j - 1);
							String imageNameTemp = imageSize.getHeight() + "&" + imageSize.getWidth() + imageName;
							File saveFile = new File(savedir, imageNameTemp);
							imageScale.scalesImage(image, saveFile, imageSize);
							fileNames.add(count++, imageNameTemp);
						}
					}
				}
			}
			return fileNames;
		} catch (IOException e) {
			log.error(ERROR_MSG);
			return null;
		}
	}

	/**
	 * 图片上传 many file(切割多种尺寸)
	 * 
	 * @param fileFolder 上传的路径
	 * @param files multipartFile集合对象
	 * @param listStr 尺寸对象
	 * @return List<String> fileNames 存放图片文件名集合
	 */
	public List<String> imageUpload(String fileFolder, List<MultipartFile> files, String listStr) {
		List<ImageSize> list = imageSizeFactory.getImageSizeList(listStr);
		return imageUpload(fileFolder, files, list);
	}

	/**
	 * buffered image
	 */
	public BufferedImage toBufferedImage(Image image) {

		if (image instanceof BufferedImage) {
			return (BufferedImage) image;
		}
		image = new ImageIcon(image).getImage();
		BufferedImage bimage = null;
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		try {
			int transparency = Transparency.OPAQUE;
			GraphicsDevice gs = ge.getDefaultScreenDevice();
			GraphicsConfiguration gc = gs.getDefaultConfiguration();
			bimage = gc.createCompatibleImage(image.getWidth(null), image.getHeight(null), transparency);
		} catch (HeadlessException e) {
			log.error("upload image the system does not have a screen");
		}
		if (bimage == null) {
			int type = BufferedImage.TYPE_INT_RGB;
			bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);
		}
		Graphics g = bimage.createGraphics();
		g.drawImage(image, 0, 0, null);
		g.dispose();
		return bimage;
	}
	
	
	
	/**
	 * 裁剪方法 
	 */
	public String imageCrop(String fileFolder, MultipartFile file, String listStr) {
		List<ImageSize> list = imageSizeFactory.getImageSizeList(listStr);
		return imageCrop(fileFolder, file, list);
	}
	
	/**
	 * 裁剪方法 
	 */
	private String imageCrop(String fileFolder, MultipartFile file, List<ImageSize> list) {

		try {
			String fileName = null;
			if (!file.isEmpty()) {
				File savedir = mkDirs(fileFolder);
				Image src = Toolkit.getDefaultToolkit().createImage(file.getBytes());
				BufferedImage image = toBufferedImage(src);
				fileName = imageUpload(fileFolder, file);
				for (int j = 1; j <= list.size(); j++) {
					ImageSize imageSize = list.get(j - 1);
					String imageName = j + fileName;
					File saveFile = new File(savedir, imageName);
					imageScale.cropImage(image, imageSize, saveFile);
				}
				if (list.size() == 1) {
					fileName = 1 + fileName;
				}
			}
			return fileName;
		} catch (IOException e) {
			log.error(ERROR_MSG);
			return null;
		}
	}
	
	/**
	 * 裁剪方法 
	 */
	public String imageCrop(String fileFolder, MultipartFile file, ImageSize imageSize) {

		try {
			String fileName = null;
			if (!file.isEmpty()) {
				File savedir = mkDirs(fileFolder);
				Image src = Toolkit.getDefaultToolkit().createImage(file.getBytes());
				BufferedImage image = toBufferedImage(src);
				fileName = imageUpload(fileFolder, file);
				fileName = 1 + fileName;
				File saveFile = new File(savedir, fileName);
				imageScale.cropImage(image, imageSize, saveFile);
			}
			return fileName;
		} catch (IOException e) {
			log.error(ERROR_MSG);
			return null;
		}
	}
	
	
	/**
	 * 切割图片
	 * @param fileFolder 待切割图片路径
	 * @param file 切割后图片路径
	 * @param listStr 图片尺寸
	 */
	public String imageThumb(String fileFolder, MultipartFile file, String listStr) {
		List<ImageSize> list = imageSizeFactory.getImageSizeList(listStr);
		return imageThumb(fileFolder, file, list);
	}
	
	/**
	 * 切割图片
	 * @param fileFolder 待切割图片路径
	 * @param file 切割后图片路径
	 * @param list 图片尺寸
	 */
	private String imageThumb(String fileFolder, MultipartFile file, List<ImageSize> list) {

		try {
			String fileName = null;
			if (!file.isEmpty()) {
				File savedir = mkDirs(fileFolder);
				Image src = Toolkit.getDefaultToolkit().createImage(file.getBytes());
				BufferedImage image = toBufferedImage(src);
				fileName = imageUpload(fileFolder, file);
				for (int j = 1; j <= list.size(); j++) {
					ImageSize imageSize = list.get(j - 1);
					String imageName = j + fileName;
					File saveFile = new File(savedir, imageName);
					imageScale.thumbImage(image, imageSize, saveFile);
				}
				if (list.size() == 1) {
					fileName = 1 + fileName;
				}
			}
			return fileName;
		} catch (IOException e) {
			log.error(ERROR_MSG);
			return null;
		}
	}
	
	/**
	 * 切割图片
	 * @param fileFolder 待切割图片路径
	 * @param file 切割后图片路径
	 * @param imageSize 图片尺寸
	 */
	public String imageThumb(String fileFolder, MultipartFile file, ImageSize imageSize) {
		
		try {
			String fileName = null;
			if (!file.isEmpty()) {
				File savedir = mkDirs(fileFolder);
				fileName = imageScale.getImageName() + "." + imageScale.contentType;
				Image src = Toolkit.getDefaultToolkit().createImage(file.getBytes());
				BufferedImage image = toBufferedImage(src);
				fileName = imageUpload(fileFolder, file);
				fileName = 1 + fileName;
				File saveFile = new File(savedir, fileName);
				imageScale.thumbImage(image, imageSize, saveFile);
			}
			return fileName;
		} catch (IOException e) {
			log.error(ERROR_MSG+e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

}