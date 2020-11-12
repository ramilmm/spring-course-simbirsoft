package com.simbirsoft.springcourse.controller;

import com.simbirsoft.springcourse.dto.ShopDto;
import com.simbirsoft.springcourse.dto.WarehouseDto;
import com.simbirsoft.springcourse.model.Shop;
import com.simbirsoft.springcourse.model.Warehouse;
import com.simbirsoft.springcourse.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.apache.commons.lang3.ObjectUtils.isEmpty;
import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;

@RestController
@RequestMapping("/api/v1/warehouse")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @GetMapping("/{id}")
    public ResponseEntity<Warehouse> findById(@PathVariable("id") Long id) {
        if (isEmpty(id)) {
            return ResponseEntity.badRequest().build();
        }

        Warehouse warehouse = warehouseService.findById(id);

        if (isEmpty(warehouse)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(warehouse);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addWarehouse(@RequestBody WarehouseDto warehouseDto) {
        if (isEmpty(warehouseDto)) {
            return ResponseEntity.badRequest().build();
        }

        warehouseService.save(warehouseDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateResidue(@RequestParam Long id,
                                          @RequestParam Integer residue) {
        if (isEmpty(id) || isEmpty(residue)) {
            return ResponseEntity.badRequest().build();
        }

        warehouseService.updateResidue(id, residue);

        return ResponseEntity.ok().build();
    }

}
