package com.bdz.generator.config;

import lombok.Data;

/**
 * @author bdz
 * @date 2018/6/1 11:15
 */
@Data
public class DataSourceConfig {
  private String URL = "jdbc:mysql://127.0.0.1:3306/auth";
  private String USER = "root";
  private String PASSWORD = "111111";
  private String DRIVER = "com.mysql.jdbc.Driver";
}
