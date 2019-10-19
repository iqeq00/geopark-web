package com.geopark.web.col;

import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.framework.enums.ErrorCodeEnum;
import com.geopark.framework.excel.ExcelOperation;
import com.geopark.framework.utils.ApiAssert;
import com.geopark.web.model.entity.*;
import com.geopark.web.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * xls 导出
 *
 * @author lichee
 */
@Slf4j
@RestController
@MultipartConfig
@RequestMapping(value = "/export")
public class ExportController extends SuperController {

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

    /**
     * 导出xls
     */
    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("导出xls")
    @GetMapping("xls")
    public void download(String keyPath, HttpServletResponse response) throws IOException {

        ApiAssert.notNull(ErrorCodeEnum.BAD_REQUEST, keyPath);
        if(keyPath.equals("geolandscape")) {
            new ExcelOperation<Geolandscape>(geolandscapeService, Geolandscape.class).write(response, "地质遗迹");
        } else if(keyPath.equals("humanlandscape")) {
            new ExcelOperation<Humanlandscape>(humanlandscapeService, Humanlandscape.class).write(response, "人文景观");
        } else if(keyPath.equals("naturallandscape")) {
            new ExcelOperation<Naturallandscape>(naturallandscapeService, Naturallandscape.class).write(response, "自然景观");
        } else if(keyPath.equals("parklibrary")) {
            new ExcelOperation<Parklibrary>(parklibraryService, Parklibrary.class).write(response, "专家库与导游库");
        } else if(keyPath.equals("researchpaper")) {
            new ExcelOperation<Researchpaper>(researchpaperService, Researchpaper.class).write(response, "相关科研论文");
        } else if(keyPath.equals("manageperson")) {
            new ExcelOperation<Manageperson>(managepersonService, Manageperson.class).write(response, "管理机构人员");
        } else if(keyPath.equals("gueststat")) {
            new ExcelOperation<Gueststat>(gueststatService, Gueststat.class).write(response, "游客统计");
        } else if(keyPath.equals("sampling")) {
            new ExcelOperation<Sampling>(samplingService, Sampling.class).write(response, "采样信息");
        } else if(keyPath.equals("earthquake")) {
            new ExcelOperation<Earthquake>(earthquakeService, Earthquake.class).write(response, "地质灾害信息");
        }
    }
}