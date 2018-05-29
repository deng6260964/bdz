package com.bdz.auth.user.service.impl;

import com.bdz.auth.user.dao.UserDAO;
import com.bdz.auth.user.service.UserService;
import com.bdz.auth.user.entity.AuthUser;
import com.bdz.core.generator.IdWorkerSingleton;
import com.bdz.core.basecrud.service.impl.BaseServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bdz
 * @date 2018/4/18 15:04
 */
@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {
  private UserDAO userDAO;
  @Autowired
  public void setUserDAO(UserDAO userDAO){
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
    this.setIdWorker(IdWorkerSingleton.INSTANCE.getInstance());
    return (AuthUser) super.create(user);
  }
}
