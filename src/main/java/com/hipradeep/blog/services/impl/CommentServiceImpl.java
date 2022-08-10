package com.hipradeep.blog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.hipradeep.blog.entities.Comment;
import com.hipradeep.blog.entities.Post;
import com.hipradeep.blog.exceptions.ResourceNotFoundException;
import com.hipradeep.blog.payloads.CommentDto;
import com.hipradeep.blog.repositories.CommentRepo;
import com.hipradeep.blog.repositories.PostRepo;
import com.hipradeep.blog.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private PostRepo postRepo;
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "Id ", postId));
		
		Comment comment = this.modelMapper.map(commentDto, Comment.class); 
		comment.setPost(post);
		Comment savedComment = this.commentRepo.save(comment); 
		return this.modelMapper.map(savedComment, CommentDto.class);
		
	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment  comment = this.commentRepo.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment", "Id ", commentId));
		
		this.commentRepo.delete(comment);

	}

}
