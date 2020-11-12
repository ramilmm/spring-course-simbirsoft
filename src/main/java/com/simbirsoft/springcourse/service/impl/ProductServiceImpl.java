package com.simbirsoft.springcourse.service.impl;

import com.simbirsoft.springcourse.dto.ProductDto;
import com.simbirsoft.springcourse.model.Product;
import com.simbirsoft.springcourse.repository.ProductRepository;
import com.simbirsoft.springcourse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setCost(productDto.getCost());
        product.setProductionDate(productDto.getProductionDate());
        product.setExpirationDate(productDto.getExpirationDate());
        product.setVat(productDto.getVat());

        productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
