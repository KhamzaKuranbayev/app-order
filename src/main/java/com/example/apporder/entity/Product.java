package com.example.apporder.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 10)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @Column(length = 20)
    private String description;

    @Column(precision = 6, scale = 2, columnDefinition = "NUMERIC")
    private Double price;

    @Column(length = 1024)
    private String photo;


}
