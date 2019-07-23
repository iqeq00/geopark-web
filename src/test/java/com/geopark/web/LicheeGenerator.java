package com.geopark.web;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.*;

/**
 * <p>
 * mysql 代码生成器演示例子
 * </p>
 *
 * @author lichee
 * @since 2019-07-08
 */
public class LicheeGenerator {

    public static void main(String[] args) {
        LicheeGenerator licheeGenerator = new LicheeGenerator();
        licheeGenerator.generator();
    }


    public void generator() {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        mpg.setGlobalConfig(getGlobalConfig());
        // 数据源配置
        mpg.setDataSource(getDataSourceConfig());
        // 策略配置
        mpg.setStrategy(getStrategyConfig());
        // 包配置
        mpg.setPackageInfo(getPackageConfig());
        // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
        mpg.setCfg(getInjectionConfig());
        // 注入模板配置
        mpg.setTemplate(getTemplateConfig());
        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

    /**
     * 获取InjectionConfig
     *
     * @return
     */
    private InjectionConfig getInjectionConfig() {
        return new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                this.setMap(map);
            }
        }.setFileOutConfigList(Collections.<FileOutConfig>singletonList(new FileOutConfig(
                "/templates/mapper.xml.ftl") {
            // 自定义输出文件目录
            @Override
            public String outputFile(TableInfo tableInfo) {
                return getResourcePath() + "/mapper/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        }));
    }

    private TemplateConfig getTemplateConfig() {
        return new TemplateConfig().setXml(null);
    }

    private PackageConfig getPackageConfig() {

        PackageConfig pc = new PackageConfig();
//        pc.setModuleName(scanner("模块名"));
        pc.setParent("com.geopark.web");
        pc.setController("col");
        pc.setEntity("model.entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setServiceImpl("service.impl");


        return pc;
    }

    private StrategyConfig getStrategyConfig() {

//        List<TableFill> tableFillList = getTableFills();
        StrategyConfig strategy = new StrategyConfig();
//        strategy.setTablePrefix("sys_");
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//字段名生成策略
        // 自定义实体，公共字段
//        strategy.setSuperEntityColumns("id");
//        strategy.setTableFillList(tableFillList);
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setEntityLombokModel(true);
        // Boolean类型字段是否移除is前缀处理
        strategy.setEntityBooleanColumnRemoveIsPrefix(true);
        strategy.setCapitalMode(false);// 全局大写命名
        // 【实体】是否生成字段常量（默认 false）
        strategy.setEntityColumnConstant(true);
        // 【实体】是否为构建者模型（默认 false）
        strategy.setEntityBuilderModel(false);
        strategy.setRestControllerStyle(false);
        strategy.setRestControllerStyle(true);
        // 备注方法
        setSuperClass(strategy);
        setBackup(strategy);
        return strategy;
    }

    private void setBackup(StrategyConfig strategy) {
        // 去除前缀
//        strategy.setTablePrefix("sys_");
        // 需要生成的表
//        strategy.setInclude(new String[] { "user" });
    }

    private void setSuperClass(StrategyConfig strategy) {

        //自定义实体父类
//        strategy.setSuperEntityClass("com.lichee.core.model.BaseModel");
        //自定义 mapper 父类
//        strategy.setSuperMapperClass("com.lichee.core.mapper.BaseMapper");
        //自定义 controller 父类
//        strategy.setSuperControllerClass("com.lichee.core.controller.SuperController");
        //自定义 service 实现类父类
//        strategy.setSuperServiceImplClass("com.lichee.core.service.impl.BaseServiceImpl");
        //自定义 service 接口父类
//        strategy.setSuperServiceClass("com.lichee.core.service.BaseService");


    }

    private DataSourceConfig getDataSourceConfig() {

        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);// 数据库类型
        dataSourceConfig.setTypeConvert(new MySqlTypeConvert() {
            @Override
            public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                if (fieldType.toLowerCase().equals("bit")) {
                    return DbColumnType.BOOLEAN;
                }
                if (fieldType.toLowerCase().equals("tinyint")) {
                    return DbColumnType.BOOLEAN;
                }
                if (fieldType.toLowerCase().equals("date")) {
                    return DbColumnType.LOCAL_DATE;
                }
                if (fieldType.toLowerCase().equals("time")) {
                    return DbColumnType.LOCAL_TIME;
                }
                if (fieldType.toLowerCase().equals("datetime")) {
                    return DbColumnType.LOCAL_DATE_TIME;
                }
                return super.processTypeConvert(globalConfig, fieldType);
            }
        });
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUrl("jdbc:mysql://172.16.254.16:3306/zigong?useSSL=false&useUnicode=true&characterEncoding=UTF8&serverTimezone=GMT");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("6818799516");
        return dataSourceConfig;
    }

    public GlobalConfig getGlobalConfig() {

        GlobalConfig gc = new GlobalConfig();

        gc.setOutputDir(getJavaPath());
        gc.setAuthor("lichee");
        gc.setOpen(false);
        gc.setFileOverride(true);// 是否覆盖文件
        gc.setActiveRecord(false);// 开启 activeRecord 模式
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(false);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList

        gc.setEntityName("%s");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");

        return gc;
    }

    /**
     * 获取TableFill策略
     *
     * @return
     */
    protected List<TableFill> getTableFills() {
        // 自定义需要填充的字段
        List<TableFill> tableFillList = new ArrayList<>();
        tableFillList.add(new TableFill("createTime", FieldFill.INSERT));
        tableFillList.add(new TableFill("updateTime", FieldFill.INSERT_UPDATE));
        tableFillList.add(new TableFill("createUid", FieldFill.INSERT));
        tableFillList.add(new TableFill("updateUid", FieldFill.INSERT_UPDATE));
        return tableFillList;
    }

    /**
     * 获取根目录
     *
     * @return
     */
    private String getRootPath() {

        return System.getProperty("user.dir");
    }

    /**
     * 获取JAVA目录
     *
     * @return
     */
    protected String getJavaPath() {

        String javaPath = getRootPath() + "/src/test/java";
        System.err.println(" Generator Java Path:【 " + javaPath + " 】");
        return javaPath;
    }

    /**
     * 获取Resource目录
     *
     * @return
     */
    protected String getResourcePath() {
        String resourcePath = getRootPath() + "/src/test/resources";
        System.err.println(" Generator Resource Path:【 " + resourcePath + " 】");
        return resourcePath;
    }

}