package com.bdz.auth.module.user.service;

import com.bdz.auth.module.user.entity.AuthUser;
import com.bdz.core.basecrud.service.BaseService;

import org.springframework.data.domain.Page;

/**
 * @author bdz
 * @date 2018/4/18 15:04
 */
public interface UserService extends BaseService {

  public Page<AuthUser> getAll(int nowPage, int pageSize);
  AuthUser add(AuthUser user);
}
