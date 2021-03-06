package com.bdz.core.generator;

/**
 * 定义生成ID的接口
 * @author bdz
 * @date 2018/5/16 11:48
 */
public interface CustomizedIdGenerator {
  /**
   * 获取生成的ID
   * @return
   */
  Long getGenerateId();
}
