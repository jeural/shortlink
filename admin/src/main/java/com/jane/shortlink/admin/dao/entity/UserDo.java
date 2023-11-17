package com.jane.shortlink.admin.dao.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * _@Description: 表 t_user 对应实体类
 */
@TableName("t_user")
@Data
public class UserDo {
    private Long id;
    private String username;
    private String password;
    private String realName;
    private String phone;
    private String mail;

    private Long deletionTime;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(fill = FieldFill.INSERT)
    private Integer delFlag;
}
