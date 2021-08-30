package org.romit.learning.simple.controller;

import org.romit.learning.simple.entity.Invoice;
import org.romit.learning.simple.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "/invoice")
@RequestMapping(value = "/invoice")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @PostMapping("/saveInvoice")
    public Invoice saveInvoice(@RequestBody Invoice inv) {
        return invoiceService.saveInvoice(inv);
    }

    @GetMapping("/getAllInvoice")
    public ResponseEntity<List<Invoice>> getAllInvoices() {
        return ResponseEntity.ok(invoiceService.getAllInvoices());
    }

    @GetMapping("/getOne/{id}")
    public Invoice getOneInvoice(@PathVariable Integer id) {
        return invoiceService.getOneInvoice(id);
    }

    @PutMapping("/modify/{id}")
    public Invoice updateInvoice(@RequestBody Invoice inv, @PathVariable Integer id) {
        return invoiceService.updateInvoice(inv, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteInvoice(@PathVariable Integer id) {
        invoiceService.deleteInvoice(id);
        return "Employee with id: " + id + " Deleted !";
    }
}
