package com.example.apporder.controller;

import com.example.apporder.dto.res.ResOverPaidInvoice;
import com.example.apporder.dto.res.Response;
import com.example.apporder.entity.Invoice;
import com.example.apporder.service.InvoiceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {

    final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/expired_invoices")
    public List<Invoice> getExpiredInvoices() {
        return invoiceService.getExpiredInvoices();
    }

    @GetMapping("/wrong_date_invoices")
    public Response getWrongDateInvoices() {
        return invoiceService.getWrongDateInvoices();
    }


    @GetMapping("/overpaid_invoices")
    public Response getOverpaidInvoices() {
        return invoiceService.getOverpaidInvoices();
    }



}
