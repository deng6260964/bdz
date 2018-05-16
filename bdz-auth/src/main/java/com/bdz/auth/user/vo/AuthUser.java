package com.bdz.auth.user.vo;


import com.bdz.core.basecrud.vo.BaseModel;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
