package com.geopark.framework.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传
 * 
 * @author lichee
 */
@Slf4j
@Service
public class FileUpload {

	private static final String ERROR_MSG = "上传文件出错...";
	public static int generateCount = 0;

	private File mkDirs(String fileFolder) {

		File savedir = new File(fileFolder);
		if (!savedir.exists()) {
			savedir.mkdirs();
		}
		return savedir;
	}

	public String fileUpload(String fileFolder, MultipartFile file) {

		try {
			String fileName = null;
			if (!file.isEmpty()) {
				File savedir = mkDirs(fileFolder);
				fileName = getFileName()+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
				File saveFile = new File(savedir, fileName);
				FileUtils.copyInputStreamToFile(file.getInputStream(), saveFile);
			}
			return fileName;
		} catch (IOException e) {
			log.error(ERROR_MSG);
			return null;
		}
	}
	
	public String fileUpload(String fileFolder, String fileName, MultipartFile file) {

		try {
			if (!file.isEmpty()) {
				File savedir = mkDirs(fileFolder);
				File saveFile = new File(savedir, fileName);
				FileUtils.copyInputStreamToFile(file.getInputStream(), saveFile);
			}
			return fileName;
		} catch (IOException e) {
			log.error(ERROR_MSG);
			return null;
		}
	}

	public List<String> fileUpload(String fileFolder, List<MultipartFile> files) {

		try {
			List<String> fileNames = new ArrayList<String>();
			if (files != null) {
				for (int i = 0; i < files.size(); i++) {
					MultipartFile file = files.get(i);
					if (!file.isEmpty()) {
						String imageName = fileUpload(fileFolder, file);
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

	public String getFileName() {

		if (generateCount > 99999) {
			generateCount = 0;
		}
		String uniqueNumber = Long.toString(System.currentTimeMillis()) + Integer.toString(generateCount);
		generateCount++;
		return uniqueNumber;
	}

}