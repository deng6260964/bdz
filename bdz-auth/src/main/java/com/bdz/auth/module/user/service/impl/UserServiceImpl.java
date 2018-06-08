package com.bdz.auth.module.user.service.impl;

import com.bdz.auth.module.user.dao.UserDao;
import com.bdz.auth.module.user.entity.AuthUser;
import com.bdz.auth.module.user.service.UserService;
import com.bdz.core.basecrud.service.impl.BaseServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author bdz
 * @date 2018/4/18 15:04
 */
@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {
  private UserDao userDAO;
  @Autowired
  public void setUserDAO(UserDao userDAO){
    this.userDAO = userDAO;
    super.setMyDao(userDAO);
  }

  @Override
  public Page<AuthUser> getAll(int pageNum, int pageSize) {
    Pageable pageable = PageRequest.of(pageNum, pageSize);
    return userDAO.findAll(pageable);
  }

  @Override
  public AuthUser add(AuthUser user) {
    return (AuthUser) super.create(user);
  }
}
