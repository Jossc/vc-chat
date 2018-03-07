package com.vcg.chat.api.model;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * created by wuyu on 2018/3/6
 */
@Data
@Accessors(chain = true)
@ToString
public class Authorities {

    private String authority;
}
