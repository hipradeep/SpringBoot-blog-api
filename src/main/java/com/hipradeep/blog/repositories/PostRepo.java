package com.hipradeep.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hipradeep.blog.entities.Category;
import com.hipradeep.blog.entities.Post;
import com.hipradeep.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {

	List<Post> findByUser(User user); 
	List<Post> findByCategory(Category category);
}
