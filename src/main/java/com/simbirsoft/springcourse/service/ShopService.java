package com.simbirsoft.springcourse.service;

import com.simbirsoft.springcourse.dto.ShopDto;
import com.simbirsoft.springcourse.model.Shop;

import java.util.List;

public interface ShopService {

    Shop findShopById(Long id);

    void saveShop(ShopDto shop);

    void deleteShop(Long id);

    List<Shop> getAll();

}
