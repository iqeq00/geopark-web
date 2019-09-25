package com.geopark.web.cpt.xls;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.geopark.web.model.entity.Geolandscape;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GeolandscapeExcel {
	
	public List<Geolandscape> readFile(File file){
		
		return readFile(file, 0);
	}

	public List<Geolandscape> readFile(File file, int sheetNum) {

		List<Geolandscape> list = new ArrayList<Geolandscape>();
		try {
			InputStream inputStream = new FileInputStream(file);
			String fileName = file.getName();
			Workbook wb = null;
			if (fileName.endsWith("xls")) {
				wb = new HSSFWorkbook(inputStream);
			} else if (fileName.endsWith("xlsx")) {
				wb = new XSSFWorkbook(inputStream);
			}
			Sheet sheet = wb.getSheetAt(sheetNum);
			int firstRowIndex = sheet.getFirstRowNum();
			int lastRowIndex = sheet.getLastRowNum();
//			Row rowBase = sheet.getRow(0);
			
			for (int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {
				Row row = sheet.getRow(rIndex + 2);
				if (row != null) {
					Geolandscape geolandscape = new Geolandscape();
					try {
						geolandscape.setId(Integer.parseInt(getString(row.getCell(0))));
					} catch (NumberFormatException e) {
						geolandscape.setId(null);
					}
					geolandscape.setParkId(Integer.parseInt(getString(row.getCell(1))));
					geolandscape.setUnitenumber(getString(row.getCell(2)));
					geolandscape.setOriginalnumber(getString(row.getCell(3)));
					geolandscape.setGname(getString(row.getCell(4)));
					geolandscape.setOriginalname(getString(row.getCell(5)));
					geolandscape.setType(getString(row.getCell(6)));
					geolandscape.setPosition(getString(row.getCell(7)));
					geolandscape.setTraffic(getString(row.getCell(8)));
					geolandscape.setLat(getString(row.getCell(9)));
					geolandscape.setLng(getString(row.getCell(10)));
					geolandscape.setAltitude(getString(row.getCell(11)));
					geolandscape.setBackground(getString(row.getCell(12)));
					geolandscape.setFeature(getString(row.getCell(13)));
					geolandscape.setEvaluation(getString(row.getCell(14)));
					geolandscape.setProtection(getString(row.getCell(15)));
					geolandscape.setValue(getString(row.getCell(16)));
					geolandscape.setCauses(getString(row.getCell(17)));
					geolandscape.setNote(getString(row.getCell(18)));
					geolandscape.setImg(getString(row.getCell(19)));
					list.add(geolandscape);
				}
			}
		} catch (FileNotFoundException e) {
			log.error("读取xls--文件未找到--出现错误...");
			e.printStackTrace();
		} catch (IOException e) {
			log.error("读取xls--io--出现错误...");
			e.printStackTrace();
		}
		return list;
	}
	
	private String getString(Cell cell) {

		try {
			if (cell != null) {
				cell.setCellType(Cell.CELL_TYPE_STRING);
				return cell.getStringCellValue();
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private String getIntgerValue(Cell cell) {

		String result = "0";
		try {
			if (cell != null) {
				cell.setCellType(Cell.CELL_TYPE_STRING);
				String res = cell.getStringCellValue();
				if(StringUtils.isNotBlank(res)){
					Double dou = Double.valueOf(res);
					Long lo = Math.round(dou);
					return lo.toString();
				}else {
					return result;
				}
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
	}
	
	private  String getValue(Cell hssfCell) {
	      if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
	          // 返回布尔类型的值
	          return String.valueOf(hssfCell.getBooleanCellValue());
	      } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
	          // 返回数值类型的值
	          Object inputValue = null;// 单元格值
	          Long longVal = Math.round(hssfCell.getNumericCellValue());
	          Double doubleVal = hssfCell.getNumericCellValue();
	          if(Double.parseDouble(longVal + ".0") == doubleVal){   //判断是否含有小数位.0
	              inputValue = longVal;
	          }
	          else{
	              inputValue = doubleVal;
	          }
	          DecimalFormat df = new DecimalFormat("#.######");    //格式化为四位小数，按自己需求选择；
	          return String.valueOf(df.format(inputValue));      //返回String类型
	      } else {
	          // 返回字符串类型的值
	          return String.valueOf(hssfCell.getStringCellValue());
	      }
	  }


}