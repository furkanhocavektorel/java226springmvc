package com.vektorel.firstproject.dto;

import com.vektorel.firstproject.entity.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductSaveRequestDto {


    private String name;
    private String description;
    private int stock;
    private Double price;
    private Long categoryId;

}
