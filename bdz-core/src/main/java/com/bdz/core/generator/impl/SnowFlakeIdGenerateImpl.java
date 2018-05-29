package com.bdz.core.generator.impl;

import com.bdz.core.generator.CustomizedIdGenerator;
import com.bdz.core.generator.SnowFlakeIdWorkerSingleton;

import org.springframework.stereotype.Service;

/**
 * SnowFlake算法ID的实现
 * @author bdz
 * @date 2018/5/16 11:49
 */
@Service("snowFlake")
public class SnowFlakeIdGenerateImpl implements CustomizedIdGenerator {
  /**
   * SnowFlake算法ID的实现
   * @return
   */
  @Override
  public Long getGenerateId() {
    return SnowFlakeIdWorkerSingleton.INSTANCE.getInstance().nextId();
  }
}
