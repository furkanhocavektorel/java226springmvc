package com.vektorel.firstproject.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HomeResponse {
   private List<ProductResponseDto> products;
   private String headerOne;
   private String headerTwo;
}
