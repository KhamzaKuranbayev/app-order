package com.example.apporder.service;

import com.example.apporder.dto.res.ResOverPaidInvoice;
import com.example.apporder.dto.res.Response;
import com.example.apporder.entity.Invoice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InvoiceService {

    List<Invoice> getExpiredInvoices();

    Response getOverpaidInvoices();

    Response getWrongDateInvoices();

}
