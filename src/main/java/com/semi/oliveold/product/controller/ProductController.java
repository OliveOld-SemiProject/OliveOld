package com.semi.oliveold.product.controller;

import com.semi.oliveold.order.dto.ProductDTO;
import com.semi.oliveold.product.dto.CategoryDTO;
import com.semi.oliveold.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
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
    public String productUpLoad(@RequestParam MultipartFile imgFile,
                                @RequestParam MultipartFile imgFile1, HttpServletRequest request) throws IOException {

         String imgPath = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\assets\\images\\product-details\\product";


         String category = request.getParameter("category");
         int categoryNum = Integer.parseInt(category.split(". ")[0]);
         String categoryName = category.split(". ")[1];

         log.info("************{}*************", categoryName);

        String originalName = imgFile.getOriginalFilename();
        String fileName = originalName.substring(originalName.lastIndexOf("\\") + 1);
        String imgServerPath = "/assets/images/product-details/product/" +fileName;
        File saveFile = new File(imgPath,fileName);
        imgFile.transferTo(saveFile);


         String originalName1 = imgFile1.getOriginalFilename();
         String fileName1 = originalName1.substring(originalName1.lastIndexOf("\\") + 1);
         String imgServerPath1 =  "/assets/images/product-details/product/" +fileName1;
         File saveFile1 = new File(imgPath,fileName1);
         imgFile1.transferTo(saveFile1);

         ProductDTO product = new ProductDTO(
                 1,
                 request.getParameter("name"),
                 Integer.parseInt(request.getParameter("price")),
                 100,
                 new Date(),
                 "Y",
                 imgServerPath,
                 imgServerPath1,
                 categoryNum,
                 categoryName
         );


         productService.insertProduct(product);

        return "redirect:/admin/product";
     }

}
