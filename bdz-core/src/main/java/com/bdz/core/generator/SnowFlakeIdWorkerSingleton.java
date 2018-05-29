package com.bdz.core.generator;


import com.bdz.core.config.IdWorkerConfig;
import com.bdz.core.util.SpringContextUtils;

/**
 * 生成SnowFlake算法id的单例
 * @author bdz
 * @date 2018/5/15 16:41
 */
public enum SnowFlakeIdWorkerSingleton {
  INSTANCE;

  private SnowFlakeIdWorker singleton;

  private SnowFlakeIdWorkerSingleton(){
    IdWorkerConfig idWorkerConfig = SpringContextUtils.getBean(IdWorkerConfig.class);
    singleton = new SnowFlakeIdWorker(idWorkerConfig.getWorkerId(), idWorkerConfig.getDatacenterId(), idWorkerConfig.getSequence());
  }
  public SnowFlakeIdWorker getInstance(){
    return singleton;
  }
}