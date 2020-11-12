package com.simbirsoft.springcourse.service.impl;

import com.simbirsoft.springcourse.dto.ShopDto;
import com.simbirsoft.springcourse.model.Shop;
import com.simbirsoft.springcourse.repository.ShopRepository;
import com.simbirsoft.springcourse.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository shopRepository;


    @Override
    public Shop findShopById(Long id) {
        return shopRepository.findById(id).orElse(null);
    }

    @Override
    public void saveShop(ShopDto shopDto) {
        Shop shop = new Shop();
        shop.setName(shopDto.getName());
        shop.setCreationDate(shopDto.getCreationDate());
        shop.setMonthProfit(shopDto.getMonthProfit());
        shop.setStatus(shopDto.getStatus());
        shopRepository.save(shop);
    }

    @Override
    public void deleteShop(Long id) {
        shopRepository.deleteById(id);
    }

    @Override
    public List<Shop> getAll() {
        return shopRepository.findAll();
    }


}
