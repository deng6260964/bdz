package com.bdz.generator.dto;

import com.bdz.generator.utils.NameUtil;

import lombok.Data;

/**
 * @author bdz
 * @date 2018/6/12 14:52
 */
@Data
public class TemplateDTO {
  //创建作者
  private String author = "bdz";
  //日期
  private String currentDate = "2017/05/03";
  //生成模板对应使用的表
  private String tableName = "auth_user";
  //包路径
  private String packageName = "com.bdz.auth";
  //备注描述
  private String tableAnnotation = "用户表";
  //文件生成对应路径
  private String diskPath = "D://";
  //表名对应驼峰命名
  private String changeTableName = NameUtil.replaceUnderLineAndUpperCase(tableName);
  //生成文件对应后缀
  private String suffix = "Service.java";
  //模板文件名称
  private String templateFileName = "service.ftl";
}
