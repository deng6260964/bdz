package com.bdz.core.basecrud.dao;

import com.bdz.core.basecrud.entity.BaseModel;

import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

/**
 * @author bdz
 * @date 2018/5/15 17:24
 */
public interface BaseDao <T extends BaseModel, String extends Serializable> extends
    CrudRepository<T,String> {
}
