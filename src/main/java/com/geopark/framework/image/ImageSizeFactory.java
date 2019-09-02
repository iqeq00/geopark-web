package com.geopark.framework.image;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * 图片尺寸工厂类 
 * 
 * @author lichee
 */
@Service
public class ImageSizeFactory {
	
	/**
	 * 根据一个字符串来匹配尺寸 
	 */
	public List<ImageSize> getImageSizeList(String imageSizeListStr){
		
		List<ImageSize> imageSizeList = new ArrayList<ImageSize>();
		if(StringUtils.isNotBlank(imageSizeListStr)){
			String[] imageSizeListArray = StringUtils.split(imageSizeListStr, ";");
			for(int i=0;i<imageSizeListArray.length;i++){
				String[] imageSizeArray = StringUtils.split(imageSizeListArray[i], ",");
				ImageSize imageSize = new ImageSize(Integer.parseInt(imageSizeArray[0]),Integer.parseInt(imageSizeArray[1]));
				imageSizeList.add(imageSize);
			}
		}
		return imageSizeList;
	}

}
