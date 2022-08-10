package com.hipradeep.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hipradeep.blog.entities.Category;
import com.hipradeep.blog.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {


}
