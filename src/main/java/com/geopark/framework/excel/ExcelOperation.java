package com.geopark.framework.excel;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Excel Operation
 *
 * @author lichee
 */
public class ExcelOperation<T> {

    private IService<T> service;
    protected Class<T> entityClass;

    public ExcelOperation(IService<T> service, Class<T> entityClass) {
        this.service = service;
        this.entityClass = entityClass;
    }

    public void read(File file) {

        EasyExcel.read(file, entityClass, new ExcelListener<T>(service)).sheet().doRead();
    }

    public void write(HttpServletResponse response, String title) throws IOException {

        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode(title, "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), entityClass).sheet("数据").doWrite(service.list());
    }

}