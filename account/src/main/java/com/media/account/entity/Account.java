package com.media.account.entity;


import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
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
