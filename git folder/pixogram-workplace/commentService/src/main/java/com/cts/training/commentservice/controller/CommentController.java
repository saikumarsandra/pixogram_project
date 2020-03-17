package com.cts.training.commentservice.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.cts.training.commentservice.entity.Comment;
import com.cts.training.commentservice.model.CommentsCountModel;
import com.cts.training.commentservice.model.CommentsData;
import com.cts.training.commentservice.model.CommentsModel;
import com.cts.training.commentservice.repository.CommentRepository;
import com.cts.training.commentservice.service.ICommentService;


@RestController
public class CommentController {

	// dependency
		private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ICommentService commentsService;
	
	@GetMapping("/comment")
	public ResponseEntity<CommentsModel> getallcomments(){
		CommentsModel result = new CommentsModel();
		result.setCommentslist(this.commentsService.getall());
		ResponseEntity<CommentsModel> data = new ResponseEntity<CommentsModel>(result, HttpStatus.OK);
		
		return data;
	}
	
	@PostMapping("/comment")
	public boolean save(@RequestBody CommentsData comment) {
		this.commentsService.save(comment);
		return true;
	}
	@GetMapping("/comment/{commentId}")
	public ResponseEntity<CommentsData> getById(@PathVariable Integer commentId){
		CommentsData data = new CommentsData();
		Comment record = new Comment();
		Optional<Comment> comment = this.commentsService.getWithId(commentId);
		if(comment.isPresent())
			record = comment.get();
		else {
		//	throw new CommentNotFoundException("comment not found");
		}
		data.setComments(record.getComments());
		data.setId(record.getId());
		data.setCreatedOn(record.getCreatedOn());
		data.setUserId(record.getUserId());
		data.setMediaId(record.getMediaId());
		ResponseEntity<CommentsData> result = new ResponseEntity<CommentsData>(data, HttpStatus.OK);
		return result;
	}
	
	
	//update user
	@PutMapping("/comment")
	public boolean update(@RequestBody CommentsData user) {
		
		this.commentsService.updateuser(user);
		return true;
		
	}
	
	@GetMapping("/getcount/{mediaid}")
	public ResponseEntity<CommentsCountModel> getCountById(@PathVariable Integer mediaid) {
		CommentsCountModel data = this.commentsService.getCountById(mediaid);
		ResponseEntity<CommentsCountModel> result = new ResponseEntity<CommentsCountModel>(data, HttpStatus.OK);
		return result;
		
	}
}


