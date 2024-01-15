package com.example.demo.service.ImplementedService;

import org.springframework.stereotype.Service;
import com.example.demo.model.Category;
import com.example.demo.service.categoryService;
import com.example.demo.repository.categoryRepository;
import java.util.List;
@Service
public class categoryServiceImp implements categoryService {

    private final categoryRepository categoryRepo;


    public categoryServiceImp(categoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Category addCategory(Category c) {
        return categoryRepo.save(c);
    }

    @Override
    public void deleteCategory(int id) {
        categoryRepo.deleteById(id);
    }

    @Override
    public Category updateCategory(Category c) {
        return  categoryRepo.save(c);
    }

    @Override
    public Category getCategoryById(int id) {
        return categoryRepo.findById(id).orElse(null);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }


}