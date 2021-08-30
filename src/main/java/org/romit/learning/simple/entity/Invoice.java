package org.romit.learning.simple.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "INVOICE")
@AllArgsConstructor
@NoArgsConstructor
public class Invoice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer invoiceId;

    @Column(name = "NAME")
    private String invoiceName;

    @Column(name = "AMOUNT")
    private Double invoiceAmount;

}
