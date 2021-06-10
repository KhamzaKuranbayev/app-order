package com.example.apporder.repository;

import com.example.apporder.entity.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Integer> {

    Detail findByOrderId(Integer order_id);

    @Query(value = "select sum(p.price) from Detail d join Product p on p.id=d.product.id where d.order.id= ?1", nativeQuery = true)
    Double getListOfDetailsByOrderId(Integer orderId);

    @Query(value = "select sum(d.quantity) from  Detail d where d.order.id = ?1", nativeQuery = true)
    Integer getQuantityByOrderId(Integer id);

    @Query(value = "select d.product.id from Detail d  where d.quantity>=8 order by d.product.id", nativeQuery = true)
    List<Integer> listOfProductIds();

}
