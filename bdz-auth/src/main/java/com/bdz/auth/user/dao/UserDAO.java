package com.bdz.auth.user.dao;


import com.bdz.auth.user.entity.AuthUser;
import com.bdz.core.basecrud.dao.BaseDao;
import com.bdz.core.basecrud.entity.BaseModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

/**
 * @author bdz
 * @date 2018/4/18 15:45
 */
@Repository
public interface UserDAO<M extends AuthUser, String extends Serializable> extends
    BaseDao<M,String> {

  Page<M> findAll(Pageable pageable);
}
