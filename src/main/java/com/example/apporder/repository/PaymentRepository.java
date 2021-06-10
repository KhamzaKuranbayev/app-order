package com.example.apporder.repository;

import com.example.apporder.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    @Query(value = "select sum(p.amount) from payment p where p.inv_id=?1", nativeQuery = true)
    Double getByInvoiceId(Integer id);

    @Query(value = "select p.inv_id from payment p group by p.invoice.id order by p.inv_id", nativeQuery = true)
    List<Integer> getByInvoice();
}
