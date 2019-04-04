package com.dongguan.trip;

import com.alibaba.fastjson.JSON;
import com.dongguan.trip.modules.buz.entity.CartEntity;
import com.dongguan.trip.modules.buz.repository.CartEntityRepository;
import com.dongguan.trip.modules.buz.repository.TripDetailEntityRepository;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TripApplicationTests {

    @Test
    public void contextLoads() {

    }

    @Test
    public void test(){

    }

}

