package com.geopark.framework.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.extension.service.IService;
import com.geopark.framework.converter.BeanConverter;
import com.geopark.framework.utils.JacksonUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Execl Listener
 *
 * @author lichee
 */
@Slf4j
public class ExcelDataListener<T, D> extends AnalysisEventListener<D> {

    private IService<T> dataService;

    private Class<T> classt;

    private final int BATCH_COUNT = 1000;
    List<T> list = new ArrayList<>();

    public ExcelDataListener(IService<T> dataService, Class<T> classt) {
        this.dataService = dataService;
        this.classt = classt;
    }

    @Override
    public void invoke(D data, AnalysisContext context) {
        log.info("解析到一条数据:{}", JacksonUtils.toJson(data));
        T t = BeanConverter.convert(classt, data);
        list.add(t);
        if (list.size() >= BATCH_COUNT) {
            saveData();
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        saveData();
        log.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        log.info("{}条数据，开始存储数据库！", list.size());
        dataService.saveBatch(list);
        log.info("存储数据库成功！");
    }

}