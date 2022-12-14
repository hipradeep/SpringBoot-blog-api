package com.hipradeep.blog.payloads;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import com.hipradeep.blog.entities.Category;
import com.hipradeep.blog.entities.Comment;
import com.hipradeep.blog.entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
	
	private Integer Id;
	
	@NotBlank
	private String title;
	@NotBlank
	private String content;
	private String imageName;
	private Date addedDate;
	private CategoryDto category;
	@NotBlank
	private UserDto user;
	
	private Set<CommentDto> comments =new HashSet<>();
}
