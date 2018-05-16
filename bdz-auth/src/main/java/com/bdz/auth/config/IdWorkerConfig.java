package com.bdz.auth.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

/**
 * SnowFlake算法生成ID需要的参数
 * @author bdz
 * @date 2018/5/15 15:53
 */
@Configuration
@ConfigurationProperties(prefix = "idworker")
//@PropertySource("classpath:application-idworker.yml")
public class IdWorkerConfig {
//  public static final String PREFIX = "idworker";

  @Getter@Setter
  /*工作机器ID*/
  private Long workerId;
  @Getter@Setter
  /*数据中心ID*/
  private Long datacenterId;
  @Getter@Setter
  /*毫秒内序列*/
  private Long sequence;
}
