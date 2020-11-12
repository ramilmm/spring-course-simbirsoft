package com.simbirsoft.springcourse.service;

import com.simbirsoft.springcourse.dto.ProductDto;
import com.simbirsoft.springcourse.model.Product;

public interface ProductService {

    Product findById(Long id);

    void save(ProductDto productDto);

    void delete(Long id);

}
