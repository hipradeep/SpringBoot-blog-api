package com.hipradeep.blog.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@Getter
@Setter
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer categoryId;
	@Column(name = "title", length = 100, nullable = false)
	private String categoryTitle;
	@Column(name = "description")
	private String categoryDescription;
}
