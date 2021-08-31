package org.romit.learning.simple.dao;

import org.romit.learning.simple.entity.Invoice;

import java.util.Map;

public interface InvoiceServiceDao {

    public void saveInvoice(Invoice invoice);

    public void updateInvoice(Invoice invoice, Integer invoiceId);

    public void deleteInvoice(Integer invoiceId);

    public Invoice getOneInvoice(Integer invoiceId);

    public Map<Integer, Invoice> getAllInvoices();
}
