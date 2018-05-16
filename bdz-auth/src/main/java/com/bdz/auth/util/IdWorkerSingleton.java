package com.bdz.auth.util;

import com.bdz.auth.config.IdWorkerConfig;
import com.bdz.core.util.IdWorker;
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