package com.cts.training.commentservice.model;

import java.util.List;

import com.cts.training.commentservice.entity.Comment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentsModel {
	
	public List<Comment> commentslist;

}
