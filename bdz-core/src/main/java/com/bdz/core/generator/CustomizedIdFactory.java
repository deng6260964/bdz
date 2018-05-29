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
    Map<String,CustomizedIdGenerator>
        customizedIdGeneratorMap = SpringContextUtils.getBeans(CustomizedIdGenerator.class);
    return customizedIdGeneratorMap.get(genratorType);
  }
}
