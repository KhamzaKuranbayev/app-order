package com.example.apporder.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp time;

    @Column(precision = 8, scale = 2, columnDefinition = "NUMERIC")
    private Double amount;

    @ManyToOne
    private Invoice inv;

    public Payment(Timestamp time, Double amount, Invoice inv) {
        this.time = time;
        this.amount = amount;
        this.inv = inv;
    }
}
