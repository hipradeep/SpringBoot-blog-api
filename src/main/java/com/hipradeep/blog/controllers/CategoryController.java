package com.hipradeep.blog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hipradeep.blog.payloads.ApiResponse;
import com.hipradeep.blog.payloads.CategoryDto;
import com.hipradeep.blog.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	// POST-create categories
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
		CategoryDto createCatDto = this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<>(createCatDto, HttpStatus.CREATED);
	}

	// PUT- update category

	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDto> upadateCategory(@Valid @RequestBody CategoryDto categoryDto,
			@PathVariable("catId") int cid) {
		CategoryDto updateCatDto = this.categoryService.updateCategory(categoryDto, cid);
		return ResponseEntity.ok(updateCatDto);
	}

	// DELETE -delete category
	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("catId") Integer cid) {
		this.categoryService.deleteCategory(cid);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category deleted Successfully!", true), HttpStatus.OK);

	}

	// GET category get
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategory() {
		return ResponseEntity.ok(this.categoryService.getAllCategories());
	}

	// GET user get
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDto> getSingleUser(@PathVariable("catId") Integer cId) {
		return ResponseEntity.ok(this.categoryService.getCategory(cId));
	}
}
