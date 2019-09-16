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

import javax.annotation.PostConstruct;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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

    @Value("${geopark.image.geolandscape.path}")
    private String geolandscapePath;
    @Value("${geopark.image.geolandscape.server}")
    private String geolandscapeServer;
    @Value("${geopark.image.humanlandscape.path}")
    private String humanlandscapePath;
    @Value("${geopark.image.humanlandscape.server}")
    private String humanlandscapeServer;
    @Value("${geopark.image.parktopic.path}")
    private String parktopicPath;
    @Value("${geopark.image.parktopic.server}")
    private String parktopicServer;
    @Value("${geopark.image.scienceactivity.path}")
    private String scienceactivityPath;
    @Value("${geopark.image.scienceactivity.server}")
    private String scienceactivityServer;
    @Value("${geopark.image.geospecimen.path}")
    private String geospecimenPath;
    @Value("${geopark.image.geospecimen.server}")
    private String geospecimenServer;
    @Value("${geopark.image.biospecimen.path}")
    private String biospecimenPath;
    @Value("${geopark.image.biospecimen.server}")
    private String biospecimenServer;
    @Value("${geopark.image.humenexhibit.path}")
    private String humenexhibitPath;
    @Value("${geopark.image.humenexhibit.server}")
    private String humenexhibitServer;
    @Value("${geopark.image.displayboard.path}")
    private String displayboardPath;
    @Value("${geopark.image.displayboard.server}")
    private String displayboardServer;
    @Value("${geopark.image.parkmeeting.path}")
    private String parkmeetingPath;
    @Value("${geopark.image.parkmeeting.server}")
    private String parkmeetingServer;
    @Value("${geopark.image.exchangeexhibition.path}")
    private String exchangeexhibitionPath;
    @Value("${geopark.image.exchangeexhibition.server}")
    private String exchangeexhibitionServer;
    @Value("${geopark.image.parkrelation.path}")
    private String parkrelationPath;
    @Value("${geopark.image.parkrelation.server}")
    private String parkrelationServer;
    @Value("${geopark.image.researchpaper.path}")
    private String researchpaperPath;
    @Value("${geopark.image.researchpaper.server}")
    private String researchpaperServer;

    private Map<String, String> map = new HashMap<String, String>();

    @PostConstruct
    public void init() {

        map.put("exchange", exchangePath);
        map.put("production", productionPath);
        map.put("geolandscape", geolandscapePath);
        map.put("humanlandscape", humanlandscapePath);
        map.put("parktopic", parktopicPath);
        map.put("scienceactivity", scienceactivityPath);
        map.put("geospecimen", geospecimenPath);
        map.put("biospecimen", biospecimenPath);
        map.put("humenexhibit", humenexhibitPath);
        map.put("displayboard", displayboardPath);
        map.put("parkmeeting", parkmeetingPath);
        map.put("exchangeexhibition", exchangeexhibitionPath);
        map.put("parkrelation", parkrelationPath);
        map.put("researchpaper", researchpaperPath);
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
            } else if(keyPath.equals("geolandscape")) {
                imageVo = invokeUpload(keyPath, geolandscapeServer, file);
            } else if(keyPath.equals("humanlandscape")) {
                imageVo = invokeUpload(keyPath, humanlandscapeServer, file);
            } else if(keyPath.equals("parktopic")) {
                imageVo = invokeUpload(keyPath, parktopicServer, file);
            } else if(keyPath.equals("scienceactivity")) {
                imageVo = invokeUpload(keyPath, scienceactivityServer, file);
            } else if(keyPath.equals("geospecimen")) {
                imageVo = invokeUpload(keyPath, geospecimenServer, file);
            } else if(keyPath.equals("biospecimen")) {
                imageVo = invokeUpload(keyPath, biospecimenServer, file);
            } else if(keyPath.equals("humenexhibit")) {
                imageVo = invokeUpload(keyPath, humenexhibitServer, file);
            } else if(keyPath.equals("exchangeexhibition")) {
                imageVo = invokeUpload(keyPath, exchangeexhibitionServer, file);
            } else if(keyPath.equals("parkmeeting")) {
                imageVo = invokeUpload(keyPath, parkmeetingServer, file);
            } else if(keyPath.equals("parkrelation")) {
                imageVo = invokeUpload(keyPath, parkrelationServer, file);
            } else if(keyPath.equals("researchpaper")) {
                imageVo = invokeUpload(keyPath, researchpaperServer, file);
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
