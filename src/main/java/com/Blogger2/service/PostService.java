package com.Blogger2.service;

import com.Blogger2.payload.PostDto;

import java.util.List;


public interface PostService {

    public PostDto createPost(PostDto postDto);

    public void deletePost(long id);

    List<PostDto> getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDto updatePost(long postid, PostDto postDto);
}
