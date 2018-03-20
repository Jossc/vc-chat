package com.vcg.chat.sample.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * created by wuyu on 2018/3/20
 */
@Data
@Accessors(chain = true)
@ToString
public class FileDescription {

    @ApiModelProperty(value = "文件名称")
    private String name;

    @ApiModelProperty(value = "文件大小")
    private Long size;

    @ApiModelProperty(value = "文件存储地址")
    private String url;


}
