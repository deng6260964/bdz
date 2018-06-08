package com.bdz.generator.config;

import lombok.Data;

/**
 * 全局配置
 * @author bdz
 * @date 2018/6/1 11:18
 */
@Data
public class GloableConfig {
  private String templatePrefixPath = "templates";
  private String projectPath = "D:\\ideaSpace\\bdz";//模板输出的项目目录
  private String bizChName;   //业务名称
  private String bizEnName;   //业务英文名称
  private String bizEnBigName;//业务英文名称(大写)
  private String moduleName = "system";  //模块名称

  private String proPackage = "com.bdz.auth";
  private String coreBasePackage = "com.bdz.core";
  private String modelPackageName = "com.bdz.modular.system.model";        //model的包名
  private String modelMapperPackageName = "com.bdz.modular.system.dao";    //model的dao
  private String entityName;              //实体的名称

  private Boolean controllerSwitch = true;    //是否生成控制器代码开关
  private Boolean indexPageSwitch = true;     //主页
  private Boolean addPageSwitch = true;       //添加页面
  private Boolean editPageSwitch = true;      //编辑页面
  private Boolean jsSwitch = true;            //js
  private Boolean infoJsSwitch = true;        //详情页面js
  private Boolean daoSwitch = true;           //dao
  private Boolean serviceSwitch = true;       //service
  private Boolean entitySwitch = true;        //生成实体的开关
  private Boolean sqlSwitch = true;           //生成sql的开关

  public void init() {
    if (entityName == null) {
      entityName = bizEnBigName;
    }
    modelPackageName = proPackage + "." + "modular.system.model";
    modelMapperPackageName = proPackage + "." + "modular.system.dao";
  }
}
