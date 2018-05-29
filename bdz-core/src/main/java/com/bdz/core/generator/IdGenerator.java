package com.bdz.core.generator;

import com.bdz.core.util.SpringContextUtils;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 自定义model的ID生成规则
 * @author bdz
 * @date 2018/5/16 11:40
 */
@Component
public class IdGenerator implements IdentifierGenerator{

  @Autowired
  private CustomizedIdGenerator customizedIdGenerator;

  @Override
  public Serializable generate(
      SharedSessionContractImplementor session, Object object) throws HibernateException {
    customizedIdGenerator = SpringContextUtils.getBean(CustomizedIdGenerator.class);
    return customizedIdGenerator.getSnowFlakeId();
  }
}
