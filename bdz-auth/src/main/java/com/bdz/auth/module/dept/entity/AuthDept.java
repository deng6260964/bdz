package com.bdz.auth.module.dept.entity;

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
public class AuthDept extends BaseModel implements Serializable {
  private static final long serialVersionUID = 1L;
  /*部门编码*/
  private String deptCode;
  /*部门名称*/
  private String deptName;
  /*部门描述*/
  private String description;
}
