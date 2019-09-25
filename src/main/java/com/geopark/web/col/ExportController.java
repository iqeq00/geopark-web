package com.geopark.web.col;

import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.web.model.entity.Geolandscape;
import com.geopark.web.service.GeolandscapeService;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/export")
public class ExportController {

    @Autowired
    private GeolandscapeService geolandscapeService;

    //创建表头
    private void createTitle(HSSFWorkbook workbook, HSSFSheet sheet) {
        HSSFRow row = sheet.createRow(0);
        //设置列宽，setColumnWidth的第二个参数要乘以256，这个参数的单位是1/256个字符宽度
        sheet.setColumnWidth(1, 12 * 256);
        sheet.setColumnWidth(3, 17 * 256);

        //设置为居中加粗
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setBold(true);
//        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setFont(font);

//        HSSFCell cell;
////        cell = row.createCell(0);
////        cell.setCellValue("ID");
////        cell.setCellStyle(style);
////
////
////        cell = row.createCell(1);
////        cell.setCellValue("显示名");
////        cell.setCellStyle(style);
////
////        cell = row.createCell(2);
////        cell.setCellValue("用户名");
////        cell.setCellStyle(style);
////
////        cell = row.createCell(3);
////        cell.setCellValue("创建时间");
////        cell.setCellStyle(style);
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("id");
        header.getCell(0).setCellStyle(style);
        header.createCell(1).setCellValue("公园编号");
        header.getCell(1).setCellStyle(style);
        header.createCell(2).setCellValue("统一编号");
        header.getCell(2).setCellStyle(style);
        header.createCell(3).setCellValue("原编号");
        header.getCell(3).setCellStyle(style);
        header.createCell(4).setCellValue("地质遗迹名称");
        header.getCell(4).setCellStyle(style);
        header.createCell(5).setCellValue("原名称");
        header.getCell(5).setCellStyle(style);
        header.createCell(6).setCellValue("遗迹类型");
        header.getCell(6).setCellStyle(style);
        header.createCell(7).setCellValue("地理位置");
        header.getCell(7).setCellStyle(style);
        header.createCell(8).setCellValue("交通状况");
        header.getCell(8).setCellStyle(style);
        header.createCell(9).setCellValue("经度");
        header.getCell(9).setCellStyle(style);
        header.createCell(10).setCellValue("纬度");
        header.getCell(10).setCellStyle(style);
        header.createCell(11).setCellValue("海拔高度");
        header.getCell(11).setCellStyle(style);
        header.createCell(12).setCellValue("地质背景");
        header.getCell(12).setCellStyle(style);
        header.createCell(13).setCellValue("评价级别");
        header.getCell(13).setCellStyle(style);
        header.createCell(14).setCellValue("保护级别");
        header.getCell(14).setCellStyle(style);
        header.createCell(15).setCellValue("观赏价值");
        header.getCell(15).setCellStyle(style);
        header.createCell(16).setCellValue("遗迹成因类型");
        header.getCell(16).setCellStyle(style);
        header.createCell(17).setCellValue("地质遗迹特征");
        header.getCell(17).setCellStyle(style);
        header.createCell(18).setCellValue("备注");
        header.getCell(18).setCellStyle(style);
    }

    /**
     * export
     */
    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("导出xls")
    @GetMapping(value ="/xls")
    public String xls(HttpServletResponse response) throws Exception {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("地址遗迹");
        createTitle(workbook, sheet);
        List<Geolandscape> list = geolandscapeService.list();

        //设置日期格式
        HSSFCellStyle style = workbook.createCellStyle();
//        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));

        //新增数据行，并且设置单元格数据
//        int rowNum = 1;
//        for (User user : rows) {
//            HSSFRow row = sheet.createRow(rowNum);
//            row.createCell(0).setCellValue(user.getId());
//            row.createCell(1).setCellValue(user.getName());
//            row.createCell(2).setCellValue(user.getUsername());
//            HSSFCell cell = row.createCell(3);
//            cell.setCellValue(user.getCreate_time());
//            cell.setCellStyle(style);
//            rowNum++;
//        }
        int rowCount = 1;
        for (Geolandscape geolandscape : list) {
            HSSFRow userRow = sheet.createRow(rowCount++);
            userRow.createCell(0).setCellValue(geolandscape.getId());
            userRow.createCell(1).setCellValue(geolandscape.getParkId());
            userRow.createCell(2).setCellValue(geolandscape.getUnitenumber());
            userRow.createCell(3).setCellValue(geolandscape.getOriginalnumber());
            userRow.createCell(4).setCellValue(geolandscape.getGname());
            userRow.createCell(5).setCellValue(geolandscape.getOriginalname());
            userRow.createCell(6).setCellValue(geolandscape.getType());
            userRow.createCell(7).setCellValue(geolandscape.getPosition());
            userRow.createCell(8).setCellValue(geolandscape.getTraffic());
            userRow.createCell(9).setCellValue(geolandscape.getLat());
            userRow.createCell(10).setCellValue(geolandscape.getLng());
            userRow.createCell(11).setCellValue(geolandscape.getAltitude());
            userRow.createCell(12).setCellValue(geolandscape.getBackground());
            userRow.createCell(13).setCellValue(geolandscape.getFeature());
            userRow.createCell(14).setCellValue(geolandscape.getEvaluation());
            userRow.createCell(15).setCellValue(geolandscape.getProtection());
            userRow.createCell(16).setCellValue(geolandscape.getValue());
            userRow.createCell(17).setCellValue(geolandscape.getCauses());
            userRow.createCell(18).setCellValue(geolandscape.getNote());
        }

//        String excelName = "导出excel例子.xls";
        String fileName = "geolandscape-"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+".xls";

        //生成excel文件
        buildExcelFile(fileName, workbook);

        //浏览器下载excel
        buildExcelDocument(fileName, workbook, response);

        return "download excel";
    }

    //生成excel文件
    protected void buildExcelFile(String filename, HSSFWorkbook workbook) throws Exception {
        FileOutputStream fos = new FileOutputStream(filename);
        workbook.write(fos);
        fos.flush();
        fos.close();
    }

    //浏览器下载excel
    protected void buildExcelDocument(String filename, HSSFWorkbook workbook, HttpServletResponse response) throws Exception {
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "utf-8"));
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }


}
