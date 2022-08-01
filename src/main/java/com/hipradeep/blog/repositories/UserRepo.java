package com.hipradeep.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hipradeep.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
