package com.geopark.web.col;

import java.io.IOException;
import java.util.*;

import javax.annotation.PostConstruct;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @Value("${geopark.image.exchange.path}")
    private String exchangePath;

    @Value("${geopark.image.production.path}")
    private String productionPath;

    @Value("${geopark.image.exchange.server}")
    private String exchangeServer;

    @Value("${geopark.image.production.server}")
    private String productionServer;

    private Map<String, String> map = new HashMap<String, String>();

    @PostConstruct
    public void init() {

        map.put("exchange", exchangePath);
        map.put("production", productionPath);
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("上传图片")
    @PostMapping(value = "/img")
    public ApiResponses<ImageVo> upload(HttpServletRequest servletRequest, String keyPath,
         @RequestParam(value="file",required=false)  MultipartFile file) {

        ApiAssert.notNull(ErrorCodeEnum.BAD_REQUEST, map.get(keyPath));
        ImageVo imageVo = null;
        if (!file.isEmpty()) {
            if (keyPath.equals("exchange")) {
                imageVo = invokeUpload(keyPath, exchangeServer, file);
            } else if(keyPath.equals("production")) {
                imageVo = invokeUpload(keyPath, productionServer, file);
            }
        } else {
            ApiAssert.failure(ErrorCodeEnum.BAD_REQUEST);
        }
        return success(imageVo);
    }

    private ImageVo invokeUpload(String keyPath, String serverPath, MultipartFile file) {

        String filename = imageUpload.imageUpload(map.get(keyPath), file);
        ImageVo imageVo = new ImageVo();
        imageVo.setPath(serverPath + filename);
        imageVo.setName(filename);
        imageVo.setOriginalName(file.getOriginalFilename());
        return imageVo;
    }



}
