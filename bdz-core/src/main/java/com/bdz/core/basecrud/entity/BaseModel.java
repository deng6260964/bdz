package com.bdz.core.basecrud.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

/**
 * @author bdz
 * @date 2018/4/18 9:53
 */
@MappedSuperclass
@Data
public class BaseModel {
  @Id
  @GenericGenerator(name="seq_id", strategy="com.bdz.core.generator.IdGenerator")
  @GeneratedValue(generator="seq_id")
  private Long uuid;
  @Column(name = "create_user")
  private String createUser;
  @Column(name = "create_time")
  private String createTime;
  private String oper;
  @Column(name = "ope_time")
  private String opeTime;
  @Column(name = "del_flag")
  private String delFlag;

}
