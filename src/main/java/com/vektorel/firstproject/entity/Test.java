package com.vektorel.firstproject.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbltest")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ad;
}
