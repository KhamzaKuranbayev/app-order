package com.example.apporder.repository;

import com.example.apporder.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

    @Query(value = "select * from invoice i where i.due <= now()", nativeQuery = true)
    List<Invoice> getAllExpired();

    @Query(value = "select * from payment p join invoice i on i.id = p.inv_id where ", nativeQuery = true)
    List<Invoice> getOverpaidInvoices();

    @Query(value = "select i from invoice i join orders o on o.id = i.order_id where i.issued <= o.date", nativeQuery = true)
    List<Invoice> getWrongDateInvoices();

}
