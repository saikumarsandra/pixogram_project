package com.cts.training.commentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.cts.training.commentservice.entity.Comment;



@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{

}
