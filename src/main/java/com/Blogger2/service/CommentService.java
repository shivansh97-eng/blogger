package com.Blogger2.service;

import com.Blogger2.payload.CommentDto;

import java.util.List;

public interface CommentService{

    public CommentDto createComment(long postId, CommentDto commentDto);

    public void deleteCommentById(long commentId);

    public List<CommentDto> getCommentByPostId(long postId);

    public List<CommentDto> getAllComments();
}
