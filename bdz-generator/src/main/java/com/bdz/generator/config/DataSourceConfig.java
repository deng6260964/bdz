package com.bdz.generator.config;

import lombok.Data;

/**
 * @author bdz
 * @date 2018/6/1 11:15
 */
@Data
public class DataSourceConfig {
  private String url = "jdbc:mysql://127.0.0.1:3306/auth";
  private String user = "root";
  private String password = "111111";
  private String driver = "com.mysql.jdbc.Driver";
}
