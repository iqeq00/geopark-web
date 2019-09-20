package com.geopark.web.col;

import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.framework.enums.ErrorCodeEnum;
import com.geopark.framework.file.FileUpload;
import com.geopark.framework.image.ImageUpload;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.framework.utils.ApiAssert;
import com.geopark.web.model.vo.FileVo;
import com.geopark.web.model.vo.ImageVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

/**
 * 文件上传
 *
 * @author lpf
 */
@Slf4j
@RestController
@MultipartConfig
@RequestMapping(value = "/upload")
public class UploadController extends SuperController {

    @Autowired
    private ImageUpload imageUpload;

    @Autowired
    private FileUpload fileUpload;

    @Value("${geopark.image.url}")
    private String imageUrl;

    @Value("${geopark.image.location}")
    private String imageLocation;

    @Value("${geopark.file.url}")
    private String fileUrl;

    @Value("${geopark.file.location}")
    private String fileLocation;

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("上传图片")
    @PostMapping(value = "/img")
    public ApiResponses<ImageVo> img(HttpServletRequest servletRequest, String keyPath,
         @RequestParam(value="file",required=false)  MultipartFile file) {

        ApiAssert.notNull(ErrorCodeEnum.BAD_REQUEST, keyPath);
        ImageVo imageVo = null;
        if (!file.isEmpty()) {
            imageVo = invokeImgUpload(keyPath, file);
        } else {
            ApiAssert.failure(ErrorCodeEnum.BAD_REQUEST);
        }
        return success(imageVo);
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("上传文件")
    @PostMapping(value = "/file")
    public ApiResponses<FileVo> file(HttpServletRequest servletRequest, String keyPath,
                                        @RequestParam(value="file",required=false)  MultipartFile file) {

        ApiAssert.notNull(ErrorCodeEnum.BAD_REQUEST, keyPath);
        FileVo fileVo = null;
        if (!file.isEmpty()) {
            fileVo = invokeFileUpload(keyPath, file);
        } else {
            ApiAssert.failure(ErrorCodeEnum.BAD_REQUEST);
        }
        return success(fileVo);
    }

    private ImageVo invokeImgUpload(String keyPath, MultipartFile file) {

        String filename = imageUpload.imageUpload(imageLocation + keyPath, file);
        ImageVo imageVo = new ImageVo();
        imageVo.setPath(imageUrl + keyPath + "/" + filename);
        imageVo.setName(filename);
        imageVo.setOriginalName(file.getOriginalFilename());
        return imageVo;
    }

    private FileVo invokeFileUpload(String keyPath, MultipartFile file) {

        String filename = fileUpload.fileUpload(fileLocation + keyPath, file);
        FileVo fileVo = new FileVo();
        fileVo.setPath(fileUrl + keyPath + "/" + filename);
        fileVo.setName(filename);
        fileVo.setOriginalName(file.getOriginalFilename());
        fileVo.setSize(file.getSize());
        return fileVo;
    }

}