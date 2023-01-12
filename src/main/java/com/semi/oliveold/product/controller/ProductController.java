package com.semi.oliveold.product.controller;

import com.semi.oliveold.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
@Slf4j
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

     @GetMapping("/upload")
    public String productUploadingView(){
        return "product-Upload";
     }

     @PostMapping("/upload")
    public String productUpLoad(){
        // 로직 추가 예정
        return "product-Upload";
     }

}
