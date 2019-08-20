package com.imooc.product.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

//@Table(name ="T_xxx" )  //表名与对象名不一致时，需添加该注解
@Entity
@Data   //数据库表与实体类做对应。
public class ProductInfo {

    /**
     * CREATE TABLE `product_info` (
     *   `product_id` varchar(32) NOT NULL,
     *   `product_name` varchar(64) NOT NULL COMMENT '商品名称',
     *   `product_price` decimal(8,2) NOT NULL COMMENT '单价',
     *   `product_stock` int(11) NOT NULL COMMENT '库存',
     *   `product_description` varchar(64) DEFAULT NULL COMMENT '描述',
     *   `product_icon` varchar(512) DEFAULT NULL COMMENT '小图',
     *   `product_status` tinyint(3) DEFAULT '0' COMMENT '商品状态,0正常1下架',
     *   `category_type` int(11) NOT NULL COMMENT '类目编号',
     *   `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
     *   `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
     *   PRIMARY KEY (`product_id`)
     * ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
     */

    @Id
    private String productId;

    /** 名字. */
    private String productName;

    /** 单价. */
    private BigDecimal productPrice;

    /** 库存. */
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;

    /** 状态, 0正常1下架. */
    private Integer productStatus;

    /** 类目编号. */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;
}
