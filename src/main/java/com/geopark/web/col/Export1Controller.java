//package com.geopark.web.col;
//
//import com.geopark.framework.annotations.ApiOperation;
//import com.geopark.framework.annotations.Resources;
//import com.geopark.framework.controller.SuperController;
//import com.geopark.framework.enums.AuthTypeEnum;
//import com.geopark.framework.enums.ErrorCodeEnum;
//import com.geopark.framework.file.FileUpload;
//import com.geopark.framework.responses.ApiResponses;
//import com.geopark.framework.utils.ApiAssert;
//import com.geopark.web.cpt.xls.GeolandscapeExcel;
//import com.geopark.web.cpt.xls.GeolandscapeExcelView;
//import com.geopark.web.model.entity.Geolandscape;
//import com.geopark.web.model.vo.FileVo;
//import com.geopark.web.service.GeolandscapeService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.http.HttpServletRequest;
//import java.io.File;
//import java.util.List;
//
///**
// * xls 导出
// *
// * @author lichee
// */
//@Slf4j
//@RestController
//@MultipartConfig
//@RequestMapping(value = "/export")
//public class Export1Controller extends SuperController {
//
//    @Autowired
//    private GeolandscapeService geolandscapeService;
//
//    /**
//     * export
//     */
//    @Resources(AuthTypeEnum.LOGIN)
//    @ApiOperation("导出xls")
//    @GetMapping(value ="/xls1")
//    public ModelAndView export(String keyPath, ModelMap model){
//
//        List<Geolandscape> list = geolandscapeService.list();
//        GeolandscapeExcelView geolandscapeExcel = new GeolandscapeExcelView();
//        model.put("list", list);
//        return new ModelAndView(geolandscapeExcel, model);
//    }
//}