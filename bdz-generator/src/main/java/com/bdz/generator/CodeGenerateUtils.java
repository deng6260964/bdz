package com.bdz.generator;

import com.bdz.generator.config.DataSourceConfig;
import com.bdz.generator.dto.TemplateDTO;
import com.bdz.generator.utils.GenerateUtils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * @author bdz
 * @date 2018/5/31 17:23
 */
public class CodeGenerateUtils {

  public Connection getConnection(DataSourceConfig dataSourceConfig) throws Exception {
    Class.forName(dataSourceConfig.getDriver());
    Connection connection =
        DriverManager.getConnection(
            dataSourceConfig.getUrl(), dataSourceConfig.getUser(), dataSourceConfig.getPassword());
    return connection;
  }

  public void generate() {
    try {
      Connection connection = getConnection(new DataSourceConfig());
      DatabaseMetaData databaseMetaData = connection.getMetaData();
      TemplateDTO templateDTO = new TemplateDTO();
      String tableName = templateDTO.getTableName();
      ResultSet resultSet = databaseMetaData.getColumns(null, "%", tableName, "%");
      // 生成model文件
      GenerateUtils.generateModelFile(
          resultSet,
          new TemplateDTO());
      GenerateUtils.generateFile(new TemplateDTO());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    CodeGenerateUtils codeGenerateUtils = new CodeGenerateUtils();
    codeGenerateUtils.generate();
  }
}
