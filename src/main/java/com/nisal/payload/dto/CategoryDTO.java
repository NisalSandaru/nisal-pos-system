package com.nisal.payload.dto;

import com.nisal.model.Store;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDTO {
    private Long id;

    private String name;

   // private Store store;

    private Long storeId;
}
