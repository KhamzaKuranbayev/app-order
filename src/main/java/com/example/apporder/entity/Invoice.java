package com.example.apporder.entity;

import com.example.apporder.entity.template.AbstractEntity;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Order order;

    @Column(precision = 8, scale = 2, columnDefinition = "NUMERIC")
    private Double amount;

    @Column(nullable = false)
    private Date issued;        // BUYURTMA BERILGAN SANA

    @Column(nullable = false)
    private Date due;           // MUDDATI

    public Invoice(Order order, Double amount, Date issued, Date due) {
        this.order = order;
        this.amount = amount;
        this.issued = issued;
        this.due = due;
    }
}
