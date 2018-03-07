package com.vcg.chat.oauth2.model;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * created by wuyu on 2018/3/6
 */
@Data
@Accessors(chain = true)
@ToString
@Entity
public class Authorities {

    @Id
    @GeneratedValue
    private Long id;

    private String authority;
}
