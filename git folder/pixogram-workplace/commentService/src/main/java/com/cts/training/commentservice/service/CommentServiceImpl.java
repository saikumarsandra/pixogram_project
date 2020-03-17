package com.cts.training.commentservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cts.training.commentservice.entity.Comment;
import com.cts.training.commentservice.model.CommentsCountModel;
import com.cts.training.commentservice.model.CommentsData;
import com.cts.training.commentservice.repository.CommentRepository;
import com.cts.training.commentservice.repository.CustomRepo;





// @Component
@Service
public class CommentServiceImpl implements ICommentService {

	@Autowired
	private CommentRepository commentsRepository;
	
	@Autowired
	private CustomRepo custom;
	
	public List<Comment> getall(){
		List<Comment> records = this.commentsRepository.findAll();
		return records;
		
	}
	
	public void save(CommentsData comment) {
		Comment data = new Comment();
		
		data.setComments(comment.getComments());
		data.setUserId(comment.getUserId());
		data.setMediaId(comment.getMediaId());
		
		this.commentsRepository.save(data);
		
	}
	
	public Optional<Comment> getWithId(Integer id){
		Optional<Comment> record= this.commentsRepository.findById(id);
		return record;
		
	}
	
	public void updateuser(CommentsData comment) {
		Comment data = new Comment();
		data.setId(comment.getId());
		data.setComments(comment.getComments());
		data.setUserId(comment.getUserId());
		data.setMediaId(comment.getMediaId());
		data.setCreatedOn(comment.getCreatedOn());
		this.commentsRepository.save(data);
	}

	@Override
	public CommentsCountModel getCountById(Integer mediaid) {
		// TODO Auto-generated method stub
		CommentsCountModel data = this.custom.findCountById(mediaid);
		return data;
	}


}
