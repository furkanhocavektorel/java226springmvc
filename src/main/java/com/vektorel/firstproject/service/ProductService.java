package com.vektorel.firstproject.service;

import com.vektorel.firstproject.dto.ProductResponseDto;
import com.vektorel.firstproject.dto.ProductSaveRequestDto;
import com.vektorel.firstproject.entity.Category;
import com.vektorel.firstproject.entity.Product;
import com.vektorel.firstproject.repository.CategoryRepository;
import com.vektorel.firstproject.repository.ProductRepository;
import com.vektorel.firstproject.util.MultiPart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final CategoryService categoryService;
    private final MultiPart multiPart;

    public boolean save(ProductSaveRequestDto dto){

        Optional<Category> category=categoryService.getById(dto.getCategoryId());

        if (category.isEmpty() || dto.getName().isEmpty() ||
        dto.getName()==""||dto.getStock()==0){
            return false;
        }

        String url=multiPart.multipartToUrl(dto.getProductImage());


        Product product= Product.builder()
                .price(dto.getPrice())
                .stock(dto.getStock())
                .name(dto.getName())
                .description(dto.getDescription())
                .category(category.get())
                .photoUrl(url)
                .build();


        repository.save(product);

        return true;
    }


    public List<ProductResponseDto> productResponseForHomePage(){
        List<ProductResponseDto> responses= new ArrayList<>();

        List<Product> products= repository.findAll();

        for (Product p : products){
            ProductResponseDto dto= new ProductResponseDto();

            dto.setAd(p.getName()+ "-" +p.getDescription());
            dto.setFiyat(p.getPrice());
            dto.setUrl(p.getPhotoUrl());

            responses.add(dto);
        }

        return responses;
    }
}
