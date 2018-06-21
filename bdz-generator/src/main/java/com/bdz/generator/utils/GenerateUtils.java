package com.bdz.generator.utils;

import com.bdz.generator.ColumnClass;
import com.bdz.generator.dto.TemplateDTO;

import freemarker.template.Template;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bdz
 * @date 2018/6/12 11:03
 */
public class GenerateUtils {

  /**
   * 根据模板生成model
   *
   * @param resultSet
   * @throws Exception
   */
  public static void generateModelFile(ResultSet resultSet, TemplateDTO templateDTO) throws Exception {

    final String suffix = ".java";
    final String path = templateDTO.getDiskPath() + templateDTO.getChangeTableName() + suffix;
    final String templateName = "Model.ftl";
    File mapperFile = new File(path);
    List<ColumnClass> columnClassList = new ArrayList<>();
    ColumnClass columnClass = null;
    while (resultSet.next()) {
      // id字段略过
      if (resultSet.getString("COLUMN_NAME").equals("id")) continue;
      columnClass = new ColumnClass();
      // 获取字段名称
      columnClass.setColumnName(resultSet.getString("COLUMN_NAME"));
      // 获取字段类型
      columnClass.setColumnType(resultSet.getString("TYPE_NAME"));
      // 转换字段名称，如 sys_name 变成 SysName
      columnClass.setChangeColumnName(
          NameUtil.replaceUnderLineAndUpperCase(resultSet.getString("COLUMN_NAME")));
      // 字段在数据库的注释
      columnClass.setColumnComment(resultSet.getString("REMARKS"));
      columnClassList.add(columnClass);
    }
    Map<String, Object> dataMap = new HashMap<>();
    dataMap.put("model_column", columnClassList);
    generateFileByTemplate(templateName, mapperFile, dataMap, templateDTO);
  }
  /**
   * 根据模板生成对应文件
   *
   * @param templateName
   * @param file
   * @param dataMap
   * @throws Exception
   */
  public static void generateFileByTemplate(
      String templateName, File file, Map<String, Object> dataMap, TemplateDTO templateDTO)
      throws Exception {
    Template template = FreeMarkerTemplateUtils.getTemplate(templateName);
    FileOutputStream fos = new FileOutputStream(file);
    dataMap.put("table_name_small", templateDTO.getTableName());
    dataMap.put("table_name", templateDTO.getChangeTableName());
    dataMap.put("author", templateDTO.getAuthor());
    dataMap.put("date", templateDTO.getCurrentDate());
    dataMap.put("package_name", templateDTO.getPackageName());
    dataMap.put("table_annotation", templateDTO.getTableAnnotation());
    Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"), 10240);
    template.process(dataMap, out);
    out.close();
  }

  /*public static void generateControllerFile(TemplateDTO templateDTO)
      throws Exception {
    final String suffix = "Controller.java";
    final String templateName = "controller.ftl";
    generateFile(suffix,templateName,templateDTO);
  }

  public static void generateServiceFile(TemplateDTO templateDTO)
      throws Exception {
    final String suffix = "Service.java";
    final String templateName = "service.ftl";
    generateFile(suffix,templateName,templateDTO);
  }
  public static void generateDaoFile(TemplateDTO templateDTO)
      throws Exception {
    final String suffix = "Dao.java";

    final String templateName = "dao.ftl";
    generateFile(suffix,templateName,templateDTO);
  }*/

  public static void generateFile(TemplateDTO templateDTO) throws Exception {
    String path = templateDTO.getDiskPath() + templateDTO.getChangeTableName() + templateDTO.getSuffix();
    File mapperFile = new File(path);
    Map<String, Object> dataMap = new HashMap<>();
    generateFileByTemplate(templateDTO.getTemplateFileName(), mapperFile, dataMap, templateDTO);
  }
}
