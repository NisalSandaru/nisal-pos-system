package com.nisal.service;

import com.nisal.exceptions.UserException;
import com.nisal.model.Category;
import com.nisal.payload.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    CategoryDTO createCategory(CategoryDTO dto) throws Exception;
    List<CategoryDTO> getCategoriesByStore(Long storeId);
    CategoryDTO updateCategory(Long id,CategoryDTO dto) throws Exception;
    void deleteCategory(Long id) throws Exception;
}
