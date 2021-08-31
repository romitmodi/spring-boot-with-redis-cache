package org.romit.learning.simple.dao.impl;

import org.romit.learning.simple.dao.InvoiceServiceDao;
import org.romit.learning.simple.entity.Invoice;
import org.springframework.data.redis.core.HashOperations;

import java.util.Map;

public class InvoiceServiceDaoImpl implements InvoiceServiceDao {
    private final static String hashReference = "Invoice";

    private HashOperations<String, Integer, Invoice> hashOperations;

    @Override
    public void saveInvoice(Invoice invoice) {
        hashOperations.putIfAbsent(hashReference, invoice.getInvoiceId(), invoice);
    }

    @Override
    public void updateInvoice(Invoice invoice, Integer invoiceId) {
        hashOperations.put(hashReference, invoiceId, invoice);
    }

    @Override
    public void deleteInvoice(Integer invoiceId) {
        hashOperations.delete(hashReference, invoiceId);
    }

    @Override
    public Invoice getOneInvoice(Integer invoiceId) {
        return hashOperations.get(hashReference, invoiceId);
    }

    @Override
    public Map<Integer, Invoice> getAllInvoices() {
        return hashOperations.entries(hashReference);
    }
}
