package com.simbirsoft.springcourse.service.impl;

import com.simbirsoft.springcourse.dto.WarehouseDto;
import com.simbirsoft.springcourse.model.Warehouse;
import com.simbirsoft.springcourse.repository.WarehouseRepository;
import com.simbirsoft.springcourse.service.ProductService;
import com.simbirsoft.springcourse.service.ShopService;
import com.simbirsoft.springcourse.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private ShopService shopService;

    @Override
    public Warehouse findById(Long id) {
        return warehouseRepository.findById(id).orElse(null);
    }

    @Override
    public void save(WarehouseDto warehouseDto) {
        Warehouse warehouse = new Warehouse();
        warehouse.setResidue(warehouseDto.getResidue());
        warehouse.setShop(shopService.findShopById(warehouseDto.getShopId()));
        warehouse.setProduct(productService.findById(warehouseDto.getProductId()));

        warehouseRepository.save(warehouse);
    }

    @Override
    public void updateResidue(Long id, Integer residue) {
        Warehouse warehouse = warehouseRepository.findById(id).orElse(null);

        if (isNotEmpty(warehouse)) {
            warehouse.setResidue(residue);
            warehouseRepository.save(warehouse);
        }
    }
}
