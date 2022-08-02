package com.hipradeep.blog.payloads;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
	private Integer categoryId;
	@NotBlank
	@Size(min=4, message = "Username must have min 4 dharacters")
	private String categoryTitle;
	@NotBlank
	@Size(min=12, message = "Username must have min 12 dharacters")
	private String categoryDescription;
	

}
