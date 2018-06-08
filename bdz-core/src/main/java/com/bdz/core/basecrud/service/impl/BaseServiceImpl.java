package com.bdz.core.basecrud.service.impl;

import com.bdz.core.basecrud.dao.BaseDao;
import com.bdz.core.basecrud.service.BaseService;
import com.bdz.core.basecrud.entity.BaseModel;
import com.bdz.core.generator.SnowFlakeIdWorker;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.text.DateFormat;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * @author bdz
 * @date 2018/4/18 11:19
 */
public class BaseServiceImpl<M extends BaseModel> implements BaseService {

  private BaseDao myDao;

  public void setMyDao(BaseDao myDao) {
    this.myDao = myDao;
  }

  @Getter @Setter private SnowFlakeIdWorker idWorker;

  @Override
  public BaseModel create(BaseModel baseModel) {
    baseModel.setDelFlag("0");
    baseModel.setCreateTime(DateFormat.getDateInstance().format(new Date()));
    return (BaseModel) myDao.save(baseModel);
  }

  @Override
  public BaseModel update(BaseModel baseModel) {
    baseModel.setOpeTime(DateFormat.getDateInstance().format(new Date()));
    return (BaseModel) myDao.save(baseModel);
  }

  @Override
  public Page findAll(Pageable pageable) {
    return null;
  }
}
