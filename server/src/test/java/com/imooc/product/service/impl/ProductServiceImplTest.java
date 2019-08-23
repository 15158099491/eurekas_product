package com.imooc.product.service.impl;

import com.imooc.product.ProductApplicationTests;
import com.imooc.product.common.DecreaseStockInput;
import com.imooc.product.common.ProductInfoOutput;
import com.imooc.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<ProductInfoOutput> infoList = productService.findList(stringList);
        Assert.assertNotNull(infoList);

    }

    @Test
    public void decreaseStock() throws Exception{
        List<DecreaseStockInput> decreaseStockInputList = new ArrayList<>();
        DecreaseStockInput decreaseStockInput= new DecreaseStockInput();
        decreaseStockInput.setProductId("164103465734242707");
        decreaseStockInput.setProductQuantity(2);
        decreaseStockInputList.add(decreaseStockInput);
        productService.decreaseStock(decreaseStockInputList);
    }
}