package com.bdz.auth.module.user.dao.impl;

import com.bdz.auth.module.user.dao.UserCustomDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

/**
 * @author bdz
 * @date 2018/5/30 15:10
 */
public class UserDaoImpl<AuthUser, String> implements UserCustomDao {

  @Autowired
  private EntityManager em;
}
