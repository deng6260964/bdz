package com.bdz.core.basecrud.service;

import com.bdz.core.basecrud.entity.BaseModel;

/**
 * @author bdz
 * @date 2018/4/18 11:19
 */
public interface BaseService<M extends BaseModel> {
  M create(M m);
  M update(M m);
}
