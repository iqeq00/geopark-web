package com.geopark.web.col;

import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.framework.enums.ErrorCodeEnum;
import com.geopark.framework.excel.ExcelOperation;
import com.geopark.framework.file.FileUpload;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.framework.utils.ApiAssert;
import com.geopark.web.model.entity.*;
import com.geopark.web.model.vo.FileVo;
import com.geopark.web.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import java.io.File;

/**
 * xls 导入
 *
 * @author lichee
 */
@Slf4j
@RestController
@MultipartConfig
@RequestMapping(value = "/import")
public class ImportController extends SuperController {

    @Autowired
    private FileUpload fileUpload;

    @Value("${geopark.file.url}")
    private String fileUrl;

    @Value("${geopark.file.location}")
    private String fileLocation;

    @Autowired
    private GeolandscapeService geolandscapeService;

    @Autowired
    private HumanlandscapeService humanlandscapeService;

    @Autowired
    private NaturallandscapeService naturallandscapeService;

    @Autowired
    private ParklibraryService parklibraryService;

    @Autowired
    private ResearchpaperService researchpaperService;

    @Autowired
    private ManagepersonService managepersonService;

    @Autowired
    private GueststatService gueststatService;

    @Autowired
    private SamplingService samplingService;

    @Autowired
    private EarthquakeService earthquakeService;

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("导入xls")
    @PostMapping(value = "/xls")
    public ApiResponses<FileVo> file(String keyPath,
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

    /**
     * 上传文件
     */
    private FileVo invokeFileUpload(String keyPath, MultipartFile file) {

        String filename = fileUpload.fileUpload(fileLocation + keyPath, file);
        FileVo fileVo = new FileVo();
        fileVo.setPath(fileUrl + keyPath + File.separator + filename);
        fileVo.setName(filename);
        fileVo.setOriginalName(file.getOriginalFilename());
        fileVo.setSize(file.getSize());
        return fileVo;
    }

    /**
     * excel操作
     */
    private void importFile(String keyPath, FileVo fileVo) {

        File file = new File(fileLocation + keyPath, fileVo.getName());
        if(keyPath.equals("geolandscape")) {
            new ExcelOperation<Geolandscape>(geolandscapeService, Geolandscape.class).read(file);
        } else if(keyPath.equals("humanlandscape")) {
            new ExcelOperation<Humanlandscape>(humanlandscapeService, Humanlandscape.class).read(file);
        } else if(keyPath.equals("naturallandscape")) {
            new ExcelOperation<Naturallandscape>(naturallandscapeService, Naturallandscape.class).read(file);
        } else if(keyPath.equals("parklibrary")) {
            new ExcelOperation<Parklibrary>(parklibraryService, Parklibrary.class).read(file);
        } else if(keyPath.equals("researchpaper")) {
            new ExcelOperation<Researchpaper>(researchpaperService, Researchpaper.class).read(file);
        } else if(keyPath.equals("manageperson")) {
            new ExcelOperation<Manageperson>(managepersonService, Manageperson.class).read(file);
        } else if(keyPath.equals("gueststat")) {
            new ExcelOperation<Gueststat>(gueststatService, Gueststat.class).read(file);
        } else if(keyPath.equals("sampling")) {
            new ExcelOperation<Sampling>(samplingService, Sampling.class).read(file);
        } else if(keyPath.equals("earthquake")) {
            new ExcelOperation<Earthquake>(earthquakeService, Earthquake.class).read(file);
        }

    }

}