package org.romit.learning.simple.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.romit.learning.simple.entity.Invoice;
import org.romit.learning.simple.exception.InvoiceNotFoundException;
import org.romit.learning.simple.repository.InvoiceRepository;
import org.romit.learning.simple.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Override
    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    @CachePut(value = "Invoice", key = "#invoiceId")
    public Invoice updateInvoice(Invoice invoice, Integer invoiceId) {
        Invoice invoiceUpdate = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new InvoiceNotFoundException("Invoice with id: " + invoiceId + " not found!"));
        invoiceUpdate.setInvoiceAmount(invoice.getInvoiceAmount());
        invoiceUpdate.setInvoiceName(invoice.getInvoiceName());
        return invoiceRepository.save(invoiceUpdate);
    }

    @Override
    @CacheEvict(value = "Invoice", key = "#invoiceId")
    public void deleteInvoice(Integer invoiceId) {
        Invoice invoiceUpdate = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new InvoiceNotFoundException("Invoice with id: " + invoiceId + " not found!"));
        invoiceRepository.delete(invoiceUpdate);
    }

    @Override
    @Cacheable(value = "Invoice", key = "#invoiceId")
    public Invoice getOneInvoice(Integer invoiceId) {
        return invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new InvoiceNotFoundException("Invoice with id: " + invoiceId + " not found!"));
    }

    @Override
    @Cacheable(value = "Invoice")
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }
}
