package com.bdz.core.generator.impl;

import com.bdz.core.generator.CustomizedIdGenerator;
import com.bdz.core.generator.IdWorkerSingleton;

import org.springframework.stereotype.Service;

/**
 * ID生成的实现
 * @author bdz
 * @date 2018/5/16 11:49
 */
@Service
public class IdGeneratorImpl implements CustomizedIdGenerator {
  /**
   * SnowFlake算法ID的实现
   * @return
   */
  @Override
  public Long getSnowFlakeId() {
    return IdWorkerSingleton.INSTANCE.getInstance().nextId();
  }
}
