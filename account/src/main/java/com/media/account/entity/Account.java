package com.media.account.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Administrator
 */
@Data
@Accessors(chain = true)
@TableName("t_account")
public class Account {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String userId;
    private Double amount;
}
