package com.nisal.repository;

import com.nisal.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    List<Category> findByStoreId(long storeId);
}
