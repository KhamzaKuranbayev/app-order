package com.example.apporder.repository;

import com.example.apporder.entity.Category;
import com.example.apporder.entity.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Integer> {

    Detail findByOrderId(Integer order_id);

}
