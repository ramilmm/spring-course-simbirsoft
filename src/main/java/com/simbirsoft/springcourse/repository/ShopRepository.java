package com.simbirsoft.springcourse.repository;

import com.simbirsoft.springcourse.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ShopRepository extends JpaRepository<Shop, Long> {

}
