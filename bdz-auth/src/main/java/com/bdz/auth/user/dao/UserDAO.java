package com.bdz.auth.user.dao;


import com.bdz.core.basecrud.dao.BaseDao;
import com.bdz.core.basecrud.vo.BaseModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author bdz
 * @date 2018/4/18 15:45
 */
@Repository
public interface UserDAO<T extends BaseModel, String extends Serializable> extends
    BaseDao<T,String> {
}
