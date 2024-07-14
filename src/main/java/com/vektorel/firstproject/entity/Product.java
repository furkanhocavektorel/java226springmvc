package com.vektorel.firstproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Product {
    /*
    onetoone:
    bir kategorinin bir ürünü
    bir ürünün bir kagetogiris olabilir

    manytomany
    tek taraflı yazılması mantıklıdır.
    iki tarafa yazılır ise aynı verileri içeren
    iki tablo oluşturur.

    onetomany
    manytoone
    * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int stock;
    private Double price;
    private String photoUrl;
/*    @ManyToMany
    private List<Category> categories;*/


    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
}
