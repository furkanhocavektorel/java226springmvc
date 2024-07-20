package com.vektorel.firstproject.service;

import com.vektorel.firstproject.dto.CategorySaveRequestDto;
import com.vektorel.firstproject.entity.Category;
import com.vektorel.firstproject.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
// dolu const
//@AllArgsConstructor
// final ile işaretlediğiniz parametler inject edilir.
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;

    public boolean save(CategorySaveRequestDto dto){
        if (dto.getCategoryName().isEmpty()){
            return false;
        }
        Category category= new Category();
        category.setName(dto.getCategoryName());
        repository.save(category);
        return true;
    }

    public Optional<Category> getById(Long id){
        return repository.findById(id);
    }



    public List<Category> getAllCategory(){
        return repository.findAll();
    }
}
