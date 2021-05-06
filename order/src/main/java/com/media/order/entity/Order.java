package com.media.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * * @author lidong
 * @since 2019-09-04
 */
@Data
@Accessors(chain = true)
public class Order  {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String orderNo;
    private String userId;
    private String commodityCode;
    private Integer count;
    private Double amount;

}
