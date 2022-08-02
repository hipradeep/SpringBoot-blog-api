package com.hipradeep.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hipradeep.blog.entities.Category;
import com.hipradeep.blog.entities.Post;
import com.hipradeep.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {

	List<Post> findByUser(User user);

	List<Post> findByCategory(Category category);

	List<Post> findByTitleContaining(String keyword);
	
	@Query("select p from Post p where p.title like :key") //p is object, nospace [:key]
	List<Post> searchByTitle(@Param("key") String title);
}
