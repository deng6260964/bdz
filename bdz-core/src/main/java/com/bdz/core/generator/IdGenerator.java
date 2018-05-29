package com.bdz.core.generator;

import com.bdz.core.config.CoreConfig;
import com.bdz.core.util.SpringContextUtils;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 自定义model的ID生成规则
 *
 * @author bdz
 * @date 2018/5/16 11:40
 */
@Component
public class IdGenerator implements IdentifierGenerator {

  private CustomizedIdGenerator customizedIdGenerator;

  @Override
  public Serializable generate(SharedSessionContractImplementor session, Object object)
      throws HibernateException {
    //获取配置文件中参数
    CoreConfig coreConfig = SpringContextUtils.getBean(CoreConfig.class);
    //根据配置文件中参数获取对应ID生成器
    CustomizedIdFactory customizedIdFactory = new CustomizedIdFactory(coreConfig.getGeneratorType());
    customizedIdGenerator = customizedIdFactory.getGenrator();
    return customizedIdGenerator.getGenerateId();
  }
}
