package com.geopark.web.cpt.xls;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geopark.web.model.entity.Geolandscape;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;


/**
 * excel view
 * 
 * @author lichee
 */
public class GeolandscapeExcelView extends AbstractXlsView {

    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest request,
									  HttpServletResponse response) throws Exception {

//		String excelName = map.get("name").toString() + ".xls";
		String excelName = "geolandscape-"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+".xls";
		response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(excelName,"utf-8"));
		response.setContentType("application/ms-excel; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		@SuppressWarnings("unchecked")
		List<Geolandscape> list = (List<Geolandscape>) map.get("list");
		Sheet sheet = workbook.createSheet("list");
		sheet.setDefaultColumnWidth(30);
		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("Arial");
		style.setFillForegroundColor(HSSFColor.BLUE.index);
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		font.setBold(true);
		font.setColor(HSSFColor.WHITE.index);
		style.setFont(font);
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

		int rowCount = 1;
		for (Geolandscape geolandscape : list) {
			Row userRow = sheet.createRow(rowCount++);
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
    }
}
