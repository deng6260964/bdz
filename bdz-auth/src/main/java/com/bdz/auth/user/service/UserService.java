package com.bdz.auth.user.service;

import com.bdz.auth.user.entity.AuthUser;
import com.bdz.core.basecrud.service.BaseService;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author bdz
 * @date 2018/4/18 15:04
 */
public interface UserService extends BaseService {

  public Page<AuthUser> getAll(int nowPage, int pageSize);
  AuthUser add(AuthUser user);
}
