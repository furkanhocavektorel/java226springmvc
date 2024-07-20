package com.vektorel.firstproject.dto;

import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
public class CategorySaveRequestDto {

    private String categoryName;
}
