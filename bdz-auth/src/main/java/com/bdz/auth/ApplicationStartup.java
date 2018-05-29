package com.bdz.auth;

import com.bdz.core.config.IdWorkerConfig;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author bdz
 * @date 2018/5/15 17:10
 */
public class ApplicationStartup  implements ApplicationListener<ContextRefreshedEvent> {

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    IdWorkerConfig service = contextRefreshedEvent.getApplicationContext().getBean(IdWorkerConfig.class);
    System.out.println(service.getWorkerId());
  }
}
