package com.bdz.auth.user.entity;


import com.bdz.core.basecrud.entity.BaseModel;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Data;

/**
 * @author bdz
 * @date 2018/4/18 11:30
 */
@Data
@Entity
public class AuthUser extends BaseModel implements Serializable{
  private static final long serialVersionUID = 1L;
  private String loginName;
  private String password;
}
