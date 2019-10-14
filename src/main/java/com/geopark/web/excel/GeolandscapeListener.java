package com.geopark.web.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.geopark.framework.converter.BeanConverter;
import com.geopark.framework.utils.JacksonUtils;
import com.geopark.web.model.entity.Geolandscape;
import com.geopark.web.service.GeolandscapeService;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 模板的读取类
 *
 * @author Jiaju Zhuang
 */
@Slf4j
public class GeolandscapeListener extends AnalysisEventListener<GeolandscapeData> {

    private GeolandscapeService geolandscapeService;

    private final int BATCH_COUNT = 1000;
    List<Geolandscape> list = new ArrayList<Geolandscape>();

    public GeolandscapeListener(GeolandscapeService geolandscapeService) {
        this.geolandscapeService = geolandscapeService;
    }

    @Override
    public void invoke(GeolandscapeData data, AnalysisContext context) {
        log.info("解析到一条数据:{}", JacksonUtils.toJson(data));
        Geolandscape geolandscape = BeanConverter.convert(Geolandscape.class, data);
        list.add(geolandscape);
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
        geolandscapeService.saveBatch(list);
        log.info("存储数据库成功！");
    }

}