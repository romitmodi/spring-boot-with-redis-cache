package org.romit.learning.simple.controller;

import org.romit.learning.simple.dao.InvoiceServiceDao;
import org.romit.learning.simple.entity.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/redis/invoice")
public class InvoiceRedisController {

    @Autowired
    InvoiceServiceDao invoiceService;

    @PostMapping("/saveInvoice")
    public ResponseEntity<Boolean> saveInvoice(@RequestBody Invoice inv) {
        invoiceService.saveInvoice(inv);
        return ResponseEntity.ok(true);
    }

    @GetMapping("/getAllInvoice")
    public ResponseEntity<Collection<Invoice>> getAllInvoices() {
        return ResponseEntity.ok(invoiceService.getAllInvoices().values());
    }

    @GetMapping("/getOne/{id}")
    public Invoice getOneInvoice(@PathVariable Integer id) {
        return invoiceService.getOneInvoice(id);
    }

    @PutMapping("/modify/{id}")
    public ResponseEntity<Boolean> updateInvoice(@RequestBody Invoice invoice, @PathVariable Integer id) {
        invoiceService.updateInvoice(invoice, id);
        return ResponseEntity.ok(true);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteInvoice(@PathVariable Integer id) {
        invoiceService.deleteInvoice(id);
        return "Employee with id: " + id + " Deleted !";
    }
}
