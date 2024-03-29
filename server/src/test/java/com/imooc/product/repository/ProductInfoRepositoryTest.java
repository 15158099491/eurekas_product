package com.imooc.product.repository;

import com.imooc.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void findByProductStatus() {

        List<ProductInfo> infoList = productInfoRepository.findByProductStatus(1);
        Assert.assertNotNull(infoList);
    }

    @Test
    public void findByProductIdIn() {
        List<String> stringList = Arrays.asList("157875196366160022","157875227953464068");
        List<ProductInfo> productInfoList = productInfoRepository.findByProductIdIn(stringList);
        Assert.assertNotNull(productInfoList);

    }
}