package com.imooc.product.service.impl;

import com.imooc.product.dataobject.ProductInfo;
import com.imooc.product.dto.CartDTO;
import com.imooc.product.enums.ProductStatusEnum;
import com.imooc.product.enums.ResultEnum;
import com.imooc.product.exception.ProductException;
import com.imooc.product.repository.ProductInfoRepository;
import com.imooc.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfo> findList(List<String> productIdList) {
        List<ProductInfo> productInfoList = productInfoRepository.findByProductIdIn(productIdList);
        return productInfoList;
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        //判断商品是否存在
        for (CartDTO cartDTO : cartDTOList) {
            Optional<ProductInfo> productInfoOptional =  productInfoRepository.findById(cartDTO.getProductId());
            if (!productInfoOptional.isPresent()){
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //判断库存是否足够
            ProductInfo productInfo = productInfoOptional.get();
            Integer result = productInfo.getProductStock()-cartDTO.getProductQuantity();
            if(result<0){
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            //减库存
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }

    }
}
