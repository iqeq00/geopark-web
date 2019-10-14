package com.geopark.web.col;

import com.alibaba.excel.EasyExcel;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.framework.enums.ErrorCodeEnum;
import com.geopark.framework.file.FileUpload;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.framework.utils.ApiAssert;
import com.geopark.web.cpt.xls.GeolandscapeExcel;
import com.geopark.web.excel.GeolandscapeData;
import com.geopark.web.excel.GeolandscapeListener;
import com.geopark.web.model.entity.Geolandscape;
import com.geopark.web.model.vo.FileVo;
import com.geopark.web.service.GeolandscapeService;
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
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * xls 导入
 *
 * @author lichee
 */
@Slf4j
@RestController
@MultipartConfig
@RequestMapping(value = "/import1")
public class Import1Controller extends SuperController {

    @Autowired
    private FileUpload fileUpload;

    @Value("${geopark.file.url}")
    private String fileUrl;

    @Value("${geopark.file.location}")
    private String fileLocation;

    @Autowired
    private GeolandscapeService geolandscapeService;

    @Autowired
    private GeolandscapeExcel geolandscapeExcel;

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("导入xls")
    @PostMapping(value = "/xls")
    public ApiResponses<FileVo> file(HttpServletRequest servletRequest, String keyPath,
                                        @RequestParam(value="file",required=false)  MultipartFile file) {

        ApiAssert.notNull(ErrorCodeEnum.BAD_REQUEST, keyPath);
        FileVo fileVo = null;
        if (!file.isEmpty()) {
            fileVo = invokeFileUpload(keyPath, file);
            importFile(keyPath, fileVo);
        } else {
            ApiAssert.failure(ErrorCodeEnum.BAD_REQUEST);
        }
        return success(fileVo);
    }

    private void importFile(String keyPath, FileVo fileVo) {

        File file = new File(fileLocation + keyPath, fileVo.getName());
        if(keyPath.equals("geolandscape")){
            EasyExcel.read(file, GeolandscapeData.class, new GeolandscapeListener(geolandscapeService)).sheet().doRead();
        }
    }

    private FileVo invokeFileUpload(String keyPath, MultipartFile file) {

        String filename = fileUpload.fileUpload(fileLocation + keyPath, file);
        FileVo fileVo = new FileVo();
        fileVo.setPath(fileUrl + keyPath + File.separator + filename);
        fileVo.setName(filename);
        fileVo.setOriginalName(file.getOriginalFilename());
        fileVo.setSize(file.getSize());
        return fileVo;
    }

}