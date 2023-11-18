package com.jane.shortlink.admin.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jane.shortlink.admin.common.database.BaseDO;
import lombok.Data;

/**
 * _@Description: 用户信息对应实体类
 */
@Data
@TableName("t_user")
public class UserDO extends BaseDO {
    private Long id;
    private String username;
    private String password;
    private String realName;
    private String phone;
    private String mail;

    private Long deletionTime;
}
