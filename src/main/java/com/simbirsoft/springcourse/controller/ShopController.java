package com.simbirsoft.springcourse.controller;

import com.simbirsoft.springcourse.dto.ShopDto;
import com.simbirsoft.springcourse.model.Shop;
import com.simbirsoft.springcourse.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.apache.commons.lang3.ObjectUtils.isEmpty;

@RestController
@RequestMapping("/api/v1/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;


    @GetMapping("/{id}")
    public ResponseEntity<Shop> findById(@PathVariable("id") Long id) {
        if (isEmpty(id)) {
            return ResponseEntity.badRequest().build();
        }

        Shop shop = shopService.findShopById(id);

        if (isEmpty(shop)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(shop);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createShop(@RequestBody ShopDto shop) {
        if (isEmpty(shop)) {
            return ResponseEntity.badRequest().build();
        }

        shopService.saveShop(shop);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteShop(@PathVariable Long id) {
        Shop shop = shopService.findShopById(id);

        if (isEmpty(shop)) {
            return ResponseEntity.notFound().build();
        }

        shopService.deleteShop(id);
        return ResponseEntity.ok().build();
    }

}
