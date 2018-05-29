package com.bdz.core.generator;

import com.bdz.core.util.SpringContextUtils;

import java.util.Map;

/**
 * @author bdz
 * @date 2018/5/29 14:47
 */
public class CustomizedIdFactory {
  private String genratorType;

  public CustomizedIdFactory(String genratorType) {
    this.genratorType = genratorType;
  }

  public CustomizedIdGenerator getGenrator() {
    //获取自定义ID生成器
    Map<String, CustomizedIdGenerator> customizedIdGeneratorMap =
        SpringContextUtils.getBeans(CustomizedIdGenerator.class);
    //根据配置返回生成器
    //TODO 异常处理
    return customizedIdGeneratorMap.get(genratorType);
  }
}
