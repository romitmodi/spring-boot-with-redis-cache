package org.romit.learning.simple.service;

import org.romit.learning.simple.entity.Invoice;

import java.util.List;

public interface InvoiceService {
    public Invoice saveInvoice(Invoice invoice);

    public Invoice updateInvoice(Invoice invoice, Integer invoiceId);

    public void deleteInvoice(Integer invoiceId);

    public Invoice getOneInvoice(Integer invoiceId);

    public List<Invoice> getAllInvoices();
}
