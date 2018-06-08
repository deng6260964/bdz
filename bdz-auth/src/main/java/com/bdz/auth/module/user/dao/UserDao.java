package com.bdz.auth.module.user.dao;

import com.bdz.auth.module.user.entity.AuthUser;
import com.bdz.core.basecrud.dao.BaseDao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author bdz
 * @date 2018/4/18 15:45
 */
@Repository
public interface UserDao<M extends AuthUser, String extends Serializable>
    extends BaseDao<M, String>, UserCustomDao<AuthUser, String> {

  Page<M> findAll(Pageable pageable);
}
