package com.example.apporder.entity;

import com.example.apporder.entity.template.AbstractEntity;
import com.example.apporder.entity.template.CharConvertor;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 14)
    private String name;

    @Column(nullable = false, columnDefinition = "CHAR", length = 3)
    @Convert(converter = CharConvertor.class)
    private String country;

    private String address;

    @Column(length = 50)
    private String phone;

}
