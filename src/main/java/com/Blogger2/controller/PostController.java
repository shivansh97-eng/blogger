package com.Blogger2.controller;

import com.Blogger2.payload.PostDto;
import com.Blogger2.service.PostService;
//import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    public PostService postService;
    public PostController(PostService postService) {
        this.postService = postService;
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<?> createPost(@Valid @RequestBody PostDto postDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

        PostDto dto = postService.createPost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable long id){
        postService.deletePost(id);
        return new ResponseEntity<>("Post is deleted!!", HttpStatus.OK);
    }


    //05/12/23


//    @GetMapping
//    public ResponseEntity<List<PostDto>> getAllPosts(){
//        List<PostDto> postDtos = postService.getAllPosts();
//        return new ResponseEntity<>(postDtos,HttpStatus.OK);
//    }



    //06/12/23

    //Sorting and Pagination

    //http://localhost:8080/api/posts?pageNo=0&pageSize=4&sortBy=title&sortDir=asc

    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts(
            @RequestParam(name = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(name = "pageSize", defaultValue = "3", required = false) int pageSize,
            @RequestParam(name = "sortBy", defaultValue = "title", required = false) String sortBy,
            @RequestParam(name = "sortDir", defaultValue = "asc", required = false) String sortDir
    ){
        List<PostDto> dtos = postService.getAllPosts(pageNo, pageSize, sortBy, sortDir);
        return new ResponseEntity<>(dtos,HttpStatus.OK);
    }


    //07/12/23

    //Update Post

    //http://localhost:8080/api/posts?postid=1


    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public ResponseEntity<PostDto> updatePost(
            @RequestParam long postid,
            @RequestBody PostDto postDto
    ){
        //PostDto postDto = postService.updatePost(postid,postDto);
        PostDto dto = postService.updatePost(postid, postDto);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }


}
