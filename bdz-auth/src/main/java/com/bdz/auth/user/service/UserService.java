package com.bdz.auth.user.service;

import com.bdz.core.basecrud.service.BaseService;

/**
 * @author bdz
 * @date 2018/4/18 15:04
 */
public interface UserService extends BaseService {
  public void test(String loginName, String password);
}
