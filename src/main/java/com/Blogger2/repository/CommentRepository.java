package com.Blogger2.repository;

import com.Blogger2.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    public List<Comment> getCommentByPostId(long postId);
}
