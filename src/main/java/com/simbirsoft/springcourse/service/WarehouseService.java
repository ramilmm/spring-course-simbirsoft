package com.simbirsoft.springcourse.service;

import com.simbirsoft.springcourse.dto.WarehouseDto;
import com.simbirsoft.springcourse.model.Warehouse;

public interface WarehouseService {

    Warehouse findById(Long id);
    void save(WarehouseDto warehouseDto);
    void updateResidue(Long id, Integer residue);

}
