package com.bdz.generator;

import com.bdz.generator.utils.FreeMarkerTemplateUtils;

import freemarker.template.Template;

import org.springframework.util.StringUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bdz
 * @date 2018/5/31 17:23
 */
public class CodeGenerateUtils {
  private final String AUTHOR = "Ay";
  private final String CURRENT_DATE = "2017/05/03";
  private final String tableName = "auth_user";
  private final String packageName = "com.evada.pm.process.manage";
  private final String tableAnnotation = "质量问题";
  private final String URL = "jdbc:mysql://127.0.0.1:3306/auth";
  private final String USER = "root";
  private final String PASSWORD = "111111";
  private final String DRIVER = "com.mysql.jdbc.Driver";
  private final String diskPath = "D://";
  private final String changeTableName = replaceUnderLineAndUpperCase(tableName);

  public Connection getConnection() throws Exception {
    Class.forName(DRIVER);
    Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
    return connection;
  }

  public static void main(String[] args) throws Exception {
    CodeGenerateUtils codeGenerateUtils = new CodeGenerateUtils();
    codeGenerateUtils.generate();
  }

  /**
   * 驼峰命名
   *
   * @param str
   * @return
   */
  public String replaceUnderLineAndUpperCase(String str) {
    StringBuffer sb = new StringBuffer();
    sb.append(str);
    int count = sb.indexOf("_");
    while (count != 0) {
      int num = sb.indexOf("_", count);
      count = num + 1;
      if (num != -1) {
        char ss = sb.charAt(count);
        char ia = (char) (ss - 32);
        sb.replace(count, count + 1, ia + "");
      }
    }
    String result = sb.toString().replaceAll("_", "");
    return StringUtils.capitalize(result);
  }

  public void generate() throws Exception {
    try {
      Connection connection = getConnection();
      DatabaseMetaData databaseMetaData = connection.getMetaData();
      ResultSet resultSet = databaseMetaData.getColumns(null, "%", tableName, "%");
      // 生成Dao文件
      generateModelFile(resultSet);
      generateControllerFile();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 根据模板生成model
   *
   * @param resultSet
   * @throws Exception
   */
  private void generateModelFile(ResultSet resultSet) throws Exception {

    final String suffix = ".java";
    final String path = diskPath + changeTableName + suffix;
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
          replaceUnderLineAndUpperCase(resultSet.getString("COLUMN_NAME")));
      // 字段在数据库的注释
      columnClass.setColumnComment(resultSet.getString("REMARKS"));
      columnClassList.add(columnClass);
    }
    Map<String, Object> dataMap = new HashMap<>();
    dataMap.put("model_column", columnClassList);
    generateFileByTemplate(templateName, mapperFile, dataMap);
  }

  private void generateControllerFile() throws Exception{
    final String suffix = "Controller.java";
    final String path = diskPath + changeTableName + suffix;
    final String templateName = "controller.ftl";
    File mapperFile = new File(path);
    Map<String,Object> dataMap = new HashMap<>();
    generateFileByTemplate(templateName,mapperFile,dataMap);
  }
  /**
   * 根据模板生成对应文件
   *
   * @param templateName
   * @param file
   * @param dataMap
   * @throws Exception
   */
  private void generateFileByTemplate(
      final String templateName, File file, Map<String, Object> dataMap) throws Exception {
    Template template = FreeMarkerTemplateUtils.getTemplate(templateName);
    FileOutputStream fos = new FileOutputStream(file);
    dataMap.put("table_name_small", tableName);
    dataMap.put("table_name", changeTableName);
    dataMap.put("author", AUTHOR);
    dataMap.put("date", CURRENT_DATE);
    dataMap.put("package_name", packageName);
    dataMap.put("table_annotation", tableAnnotation);
    Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"), 10240);
    template.process(dataMap, out);
  }
}
