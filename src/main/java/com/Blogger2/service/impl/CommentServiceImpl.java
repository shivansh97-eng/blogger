package com.Blogger2.service.impl;

import com.Blogger2.entity.Comment;
import com.Blogger2.entity.Post;
import com.Blogger2.exception.ResourceNotFoundException;
import com.Blogger2.payload.CommentDto;
import com.Blogger2.repository.CommentRepository;
import com.Blogger2.repository.PostRepository;
import com.Blogger2.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    public PostRepository postRepo;

    public CommentRepository commentRepo;

    public CommentServiceImpl(PostRepository postRepo, CommentRepository commentRepo) {
        this.postRepo = postRepo;
        this.commentRepo = commentRepo;
    }


    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {
        Post post = postRepo.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post is not found by ID:" + postId)
        );

        Comment comment = new Comment();
        comment.setName(commentDto.getName());
        comment.setBody(commentDto.getBody());
        comment.setEmail(commentDto.getEmail());
        comment.setPost(post);

        Comment savedComment = commentRepo.save(comment);

        CommentDto dto = new CommentDto();
        dto.setId(savedComment.getId());
        dto.setName(savedComment.getName());
        dto.setBody(savedComment.getBody());
        dto.setEmail(commentDto.getEmail());

        return dto;
    }




    @Override
    public void deleteCommentById(long commentId) {
        commentRepo.findById(commentId).orElseThrow(
                ()->new ResourceNotFoundException("Comment is not found by ID:"+commentId)
        );
        commentRepo.deleteById(commentId);
    }



    @Override
    public List<CommentDto> getCommentByPostId(long postId) {
        List<Comment> comments = commentRepo.getCommentByPostId(postId);
        List<CommentDto> commentDtos = comments.stream().map(c->mapToDto(c)).collect(Collectors.toList());

        return commentDtos;
    }





    @Override
    public List<CommentDto> getAllComments() {
        List<Comment> comments = commentRepo.findAll();
        List<CommentDto> commentDtos = comments.stream().map(c -> mapToDto(c)).collect(Collectors.toList());

        return commentDtos;
    }


    public CommentDto mapToDto(Comment comment){
        CommentDto dto = new CommentDto();
        dto.setId(comment.getId());
        dto.setName(comment.getName());
        dto.setBody(comment.getBody());
        dto.setEmail(comment.getEmail());

        return dto;
    }

}