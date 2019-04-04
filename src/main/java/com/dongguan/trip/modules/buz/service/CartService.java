package com.dongguan.trip.modules.buz.service;

import com.dongguan.trip.modules.buz.entity.CartEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Set;

public interface CartService {

    Page<CartEntity> queryPage(CartEntity cartEntity, Integer startPage, Integer pageSize, Sort.Direction direction, String... properties);

    void save(CartEntity cartEntity);

    List<CartEntity> findAllById(Set<Long> ids);

    CartEntity findById(Long id);


    List<CartEntity> findAllByUser(Long uid);

    void delete(Long id) throws Exception;
}
