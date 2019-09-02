package com.geopark.framework.image;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 图片尺寸对象
 * 
 * @author lichee
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ImageSize {

	/**图片宽度*/
	private int width;
	/**图片高度*/
	private int height;
}
