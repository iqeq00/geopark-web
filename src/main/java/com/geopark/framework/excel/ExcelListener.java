package com.geopark.framework.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.extension.service.IService;
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
public class ExcelListener<T> extends AnalysisEventListener<T> {

    private IService<T> dataService;

    private final int BATCH_COUNT = 1000;
    List<T> list = new ArrayList<>();

    public ExcelListener(IService<T> dataService) {
        this.dataService = dataService;
    }

    @Override
    public void invoke(T data, AnalysisContext context) {
        log.info("解析到一条数据:{}", JacksonUtils.toJson(data));
        list.add(data);
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