package com.bdz.core.util;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * 自定义model的ID生成规则
 * @author bdz
 * @date 2018/5/16 11:40
 */
public class CustomizedIdGenerator implements IdentifierGenerator{

  @Autowired
  private IdGenerator idGenerator;

  @Override
  public Serializable generate(
      SharedSessionContractImplementor session, Object object) throws HibernateException {
    idGenerator = SpringContextUtils.getBean(IdGenerator.class);
    return idGenerator.getSnowFlakeId();
  }
}
