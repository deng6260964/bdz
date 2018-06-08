package com.bdz.auth.module.role.entity;

import com.bdz.core.basecrud.entity.BaseModel;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Data;

/**
 * @author bdz
 * @date 2018/5/31 14:37
 */
@Data
@Entity
public class AuthRole extends BaseModel implements Serializable {
  private static final long serialVersionUID = 1L;
  /*角色编码*/
  private String roleCode;
  /*角色名称*/
  private String roleName;
  /*角色描述*/
  private String description;
}
