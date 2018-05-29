package com.bdz.core.config;

import com.sun.xml.internal.bind.v2.model.core.ID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

/**
 * @author bdz
 * @date 2018/5/29 14:57
 */
@Configuration
@ConfigurationProperties(prefix = "bdz.core")
public class CoreConfig {
  /*snowFlake算法生成ID*/
  public final static String SNOWFLAKE="snowFlake";
  @Getter@Setter
  /*ID 生成器具体实现类*/
  private String generatorType;
}
