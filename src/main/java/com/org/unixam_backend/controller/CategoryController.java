package com.org.unixam_backend.controller;

import com.org.unixam_backend.model.exam.Category;
import com.org.unixam_backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    //add category
    @PostMapping("/")
    public ResponseEntity<?> addCategory(@RequestBody Category category)
    {
     Category cat1=this.categoryService.addCategory(category);
     return  ResponseEntity.ok(cat1);
    }

    //get single category
    @GetMapping("/{categoryId}")
    public Category getCategory(@PathVariable("categoryId") Long id)
    {

        return  this.categoryService.getCategory(id);
    }

    //get all categories
    @GetMapping("/")
    public ResponseEntity<?> getCategories()
    {
        return  ResponseEntity.ok(this.categoryService.getCategories());
    }

    //update any category
    @PutMapping("/")
    public  Category updateCategory(@RequestBody Category category)
    {
        return this.categoryService.updateCategory(category);
    }

    //delete Category
    @DeleteMapping("/{id}")
    public  void  deleteCategory(@PathVariable("id") Long id)
    {
        this.categoryService.delete(id);
    }
}
