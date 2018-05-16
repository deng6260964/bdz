package com.bdz.auth.user.service.impl;

import com.bdz.auth.user.dao.UserDAO;
import com.bdz.auth.user.service.UserService;
import com.bdz.auth.user.vo.AuthUser;
import com.bdz.auth.util.IdWorkerSingleton;
import com.bdz.core.basecrud.service.impl.BaseServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author bdz
 * @date 2018/4/18 15:04
 */
@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {
  private UserDAO userDAO;
  @Autowired
  public void setUserDAO(UserDAO userDAO){
    super.setMyDao(userDAO);
  }

  @Override
  public void test(String loginName, String password) {
    AuthUser m = new AuthUser();
    this.setIdWorker(IdWorkerSingleton.INSTANCE.getInstance());
    m.setLoginName(loginName);
    m.setPassword(password);
    super.create(m);
  }
}
