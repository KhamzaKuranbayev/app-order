package com.example.apporder.repository;

import com.example.apporder.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("select o from Order o where o.date < ?1")
    List<Order> getOrdersWithoutDetails(Date date);

    @Query(value = "select o.id, o.date, c.name from orders o join customer c on c.id = o.cust_id " +
            "where c.id = ?1 and c.name = ?2 and (o.date between ?1 and ?2) LIMIT 1", nativeQuery = true)
    Order getCustomersLastOrder(Integer id, String name, String startDate, String finishDate);

    @Query(value = " select i.order_id from orders o join invoice  i on i.order_id = o.id  group by i.order_id", nativeQuery = true)
    List<Integer> getOrdersByOrderId();

    @Query(value = "select d.order_id from Detail d ", nativeQuery = true)
    List<Integer> listOfOrderIds();

    @Query(value = "select count(o) from orders o join Detail d on d.order_id = o.id " +
            "join Product pr on pr.id = d.product_id " +
            "where pr.id = ?1", nativeQuery = true)
    Integer getOrderCountByProductId(Integer productId);

    @Query(value = "select count(o) from orders o join customer c on c.id=o.cust_id " +
            "where o.date between ?1 and ?2 and c.country= ?3", nativeQuery = true)
    Integer getCountOrdersByCountry(String start, String finish, String countryCode);

}
