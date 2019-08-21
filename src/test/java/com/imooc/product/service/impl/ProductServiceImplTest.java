package com.imooc.product.service.impl;

import com.imooc.product.ProductApplicationTests;
import com.imooc.product.dataobject.ProductInfo;
import com.imooc.product.dto.CartDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Component  + extends ProductApplicationTests  相当于@RunWith(SpringRunner.class) + @SpringBootTest
 */
@Component
public class ProductServiceImplTest extends ProductApplicationTests {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> infoList = productService.findUpAll();
        Assert.assertNotNull(infoList);

    }

    @Test
    public void findList() throws Exception{

        List<String> stringList = Arrays.asList("157875196366160022","157875227953464068");
        List<ProductInfo> infoList = productService.findList(stringList);
        Assert.assertNotNull(infoList);

    }

    @Test
    public void decreaseStock() throws Exception{
        List<CartDTO> cartDTOList = new ArrayList<>();
        CartDTO cartDTO1= new CartDTO();
        cartDTO1.setProductId("164103465734242707");
        cartDTO1.setProductQuantity(2);
        cartDTOList.add(cartDTO1);
        productService.decreaseStock(cartDTOList);
    }
}