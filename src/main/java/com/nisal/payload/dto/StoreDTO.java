package com.nisal.payload.dto;

import com.nisal.domain.StoreStatus;
import com.nisal.model.StoreContact;
import com.nisal.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StoreDTO {

    private Long id;

    private String brand;

    private UserDto storeAdmin;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private String description;

    private String storeType;

    private StoreStatus status;

    private StoreContact contact;
}
