package com.semi.oliveold.product.controller;

import com.semi.oliveold.product.dto.CategoryDTO;
import com.semi.oliveold.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
@Slf4j
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

     @GetMapping("/product")
    public String productUploadingView(Model model){

        List<CategoryDTO> categoryList = productService.findByAllCategory();
        model.addAttribute("categoryList", categoryList);

        return "/admin/product-Upload";
     }

     @PostMapping("/upload")
    public String productUpLoad(){
        // 로직 추가 예정
        return "product-Upload";
     }

}
