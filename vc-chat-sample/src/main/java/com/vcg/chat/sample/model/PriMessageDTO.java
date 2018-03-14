package com.vcg.chat.sample.model;

import com.vcg.chat.api.model.User;
import com.vcg.chat.logic.model.PriMessage;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * created by wuyu on 2018/3/14
 */
@Data
@Accessors(chain = true)
public class PriMessageDTO {

    private User user;

    private User toUser;

    private List<PriMessage> priMessages;
}
