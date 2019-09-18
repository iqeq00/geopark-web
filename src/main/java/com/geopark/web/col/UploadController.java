package com.geopark.web.col;

import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.framework.enums.ErrorCodeEnum;
import com.geopark.framework.image.ImageUpload;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.framework.utils.ApiAssert;
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

    @Value("${geopark.image.url}")
    private String url;

    @Value("${geopark.image.location}")
    private String location;

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("上传图片")
    @PostMapping(value = "/img")
    public ApiResponses<ImageVo> upload(HttpServletRequest servletRequest, String keyPath,
         @RequestParam(value="file",required=false)  MultipartFile file) {

        ApiAssert.notNull(ErrorCodeEnum.BAD_REQUEST, keyPath);
        ImageVo imageVo = null;
        if (!file.isEmpty()) {
            imageVo = invokeUpload(keyPath, file);
        } else {
            ApiAssert.failure(ErrorCodeEnum.BAD_REQUEST);
        }
        return success(imageVo);
    }

    private ImageVo invokeUpload(String keyPath, MultipartFile file) {

        String filename = imageUpload.imageUpload(location + keyPath, file);
        ImageVo imageVo = new ImageVo();
        imageVo.setPath(url + keyPath + "/" + filename);
        imageVo.setName(filename);
        imageVo.setOriginalName(file.getOriginalFilename());
        return imageVo;
    }

}