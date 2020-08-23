package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDAO invoiceDAO;
    @Autowired
    private ProductDAO productDAO;
    @Test
    public void testInvoiceDaoSave(){
        //Given
        Product product1 = new Product("product1");
        Product product2 = new Product("product2");
        Item item1 = new Item(product1, BigDecimal.valueOf(2.5), 3);
        Item item2 = new Item(product2, BigDecimal.valueOf(4.5), 5);
        Item item3 = new Item(product1, BigDecimal.valueOf(1), 5);
        Invoice invoice = new Invoice("12345");
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);
        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);
        //When
        invoiceDAO.save(invoice);
        //Then
        int id = invoice.getId();
        Optional<Invoice> readInvoice = invoiceDAO.findById(id);
        Assert.assertTrue(readInvoice.isPresent());
        //CleanUp
        invoiceDAO.deleteById(id);
    }
}
