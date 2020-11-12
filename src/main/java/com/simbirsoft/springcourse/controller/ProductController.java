package com.simbirsoft.springcourse.controller;

import com.simbirsoft.springcourse.dto.ProductDto;
import com.simbirsoft.springcourse.dto.ShopDto;
import com.simbirsoft.springcourse.model.Product;
import com.simbirsoft.springcourse.model.Shop;
import com.simbirsoft.springcourse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.apache.commons.lang3.ObjectUtils.isEmpty;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") Long id) {
        if (isEmpty(id)) {
            return ResponseEntity.badRequest().build();
        }

        Product product = productService.findById(id);

        if (isEmpty(product)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(product);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addProduct(@RequestBody ProductDto productDto) {
        if (isEmpty(productDto)) {
            return ResponseEntity.badRequest().build();
        }

        productService.save(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        Product product = productService.findById(id);

        if (isEmpty(product)) {
            return ResponseEntity.notFound().build();
        }

        productService.delete(id);
        return ResponseEntity.ok().build();
    }


}
