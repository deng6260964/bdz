package com.bdz.auth.util;

import com.bdz.core.util.IdGenerator;

import org.springframework.stereotype.Service;

/**
 * ID生成的实现
 * @author bdz
 * @date 2018/5/16 11:49
 */
@Service
public class IdGeneratorImpl implements IdGenerator {
  /**
   * SnowFlake算法ID的实现
   * @return
   */
  @Override
  public Long getSnowFlakeId() {
    return IdWorkerSingleton.INSTANCE.getInstance().nextId();
  }
}
