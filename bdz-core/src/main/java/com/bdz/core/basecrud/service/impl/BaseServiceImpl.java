package com.bdz.core.basecrud.service.impl;


import com.bdz.core.basecrud.dao.BaseDao;
import com.bdz.core.basecrud.service.BaseService;
import com.bdz.core.basecrud.entity.BaseModel;
import com.bdz.core.generator.IdWorker;

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

  public void setMyDao(BaseDao myDao){
    this.myDao = myDao;
  }
  @Getter@Setter
  private IdWorker idWorker;
  @Override
  public BaseModel create(BaseModel baseModel) {
    baseModel.setUuid(idWorker.nextId());
    baseModel.setDelFlag("0");
    baseModel.setOpeDate(DateFormat.getDateInstance().format(new Date()));
    return (BaseModel) myDao.save(baseModel);
  }

  @Override
  public BaseModel update(BaseModel baseModel) {
    return (BaseModel) myDao.save(baseModel);
  }
}
