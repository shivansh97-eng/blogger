package com.Blogger2.controller;

import com.Blogger2.payload.CommentDto;
import com.Blogger2.service.CommentService;
import com.Blogger2.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private CommentService commentService;

    private PostService postService;

    public CommentController(CommentService commentService, PostService postService) {
        this.commentService = commentService;
        this.postService = postService;
    }


    @PostMapping
    public ResponseEntity<CommentDto> createComment(               //http://localhost:8080/api/comments?postId=1
            @RequestParam(name = "postId") long postId,
            @RequestBody CommentDto commentDto
    ){
        CommentDto dto = commentService.createComment(postId, commentDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }



    @DeleteMapping("/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable long commentId){
        commentService.deleteCommentById(commentId);
        return new ResponseEntity<>("Comment is deleted",HttpStatus.OK);
    }



    @GetMapping("/{postId}")
    public ResponseEntity<List<CommentDto>> getCommentsByPosId(@PathVariable long postId){
        List<CommentDto> commentDtos = commentService.getCommentByPostId(postId);
        return new ResponseEntity<>(commentDtos,HttpStatus.OK);
    }




    @GetMapping
    public ResponseEntity<List<CommentDto>> getAllComments(){
        List<CommentDto> commentDtos = commentService.getAllComments();
        return new ResponseEntity<>(commentDtos,HttpStatus.OK);
    }


}