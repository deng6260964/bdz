package com.bdz.generator;

import com.bdz.generator.config.DataSourceConfig;
import com.bdz.generator.dto.TemplateDTO;
import com.bdz.generator.utils.GenerateUtils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

/**
 * @author bdz
 * @date 2018/6/12 15:04
 */
public class CodeGenerator {
  public static void generate(Connection connection,TemplateDTO templateDTO){
    try {
      DatabaseMetaData databaseMetaData = connection.getMetaData();
      String tableName = templateDTO.getTableName();
      ResultSet resultSet = databaseMetaData.getColumns(null, "%", tableName, "%");
      // 生成Dao文件
      GenerateUtils.generateModelFile(
          resultSet,
          templateDTO);
      GenerateUtils.generateFile("Controller.java","controller.ftl",new TemplateDTO());
      GenerateUtils.generateFile("Service.java","service.ftl",new TemplateDTO());
      GenerateUtils.generateFile("ServiceImpl.java","serviceImpl.ftl",new TemplateDTO());
      GenerateUtils.generateFile("Dao.java","dao.ftl",new TemplateDTO());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
