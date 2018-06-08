package com.bdz.core.basecrud.service;

import com.bdz.core.basecrud.entity.BaseModel;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author bdz
 * @date 2018/4/18 11:19
 */
public interface BaseService<M extends BaseModel> {
  M create(M m);
  M update(M m);

  /**
   * 根据分页参数查询
   * @param pageable
   * @return
   */
  Page<M> findAll(Pageable pageable);
}
