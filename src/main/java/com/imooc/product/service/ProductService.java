package com.imooc.product.service;

import com.imooc.product.dataobject.ProductInfo;

import java.util.List;

/**
 * 商品
 */
public interface ProductService {

    List<ProductInfo> findUpAll();
}
