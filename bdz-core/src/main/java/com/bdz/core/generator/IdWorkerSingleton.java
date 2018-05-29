package com.bdz.core.generator;


import com.bdz.core.config.IdWorkerConfig;
import com.bdz.core.util.SpringContextUtils;

/**
 * 生成SnowFlake算法id的单例
 * @author bdz
 * @date 2018/5/15 16:41
 */
public enum IdWorkerSingleton {
  INSTANCE;

  private IdWorker singleton;

  private IdWorkerSingleton(){
    IdWorkerConfig idWorkerConfig = SpringContextUtils.getBean(IdWorkerConfig.class);
    singleton = new IdWorker(idWorkerConfig.getWorkerId(),idWorkerConfig.getDatacenterId(),idWorkerConfig.getSequence());
  }
  public IdWorker getInstance(){
    return singleton;
  }
}