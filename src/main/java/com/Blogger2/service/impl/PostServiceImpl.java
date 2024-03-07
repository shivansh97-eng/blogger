package com.Blogger2.service.impl;

import com.Blogger2.entity.Post;
import com.Blogger2.exception.ResourceNotFoundException;
import com.Blogger2.payload.PostDto;
import com.Blogger2.repository.PostRepository;
import com.Blogger2.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepo;

    public PostServiceImpl(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public PostDto createPost(PostDto postDto){
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        Post savedPost = postRepo.save(post);

        PostDto dto = new PostDto();
        dto.setId(savedPost.getId());
        dto.setTitle(savedPost.getTitle());
        dto.setDescription(savedPost.getDescription());
        dto.setContent(savedPost.getContent());
//        dto.setMessage("Post is created");

        return dto;
    }

    @Override
    public void deletePost(long id){
        postRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Post is not found by id:" + id)
        );
        postRepo.deleteById(id);
    }


    //05/12/23

//    @Override
//    public List<PostDto> getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {
//        List<Post> posts = postRepo.findAll();
//        List<PostDto> dtos = posts.stream().map(p -> mapToDto(p)).collect(Collectors.toList());
//        return dtos;
//    }



    //06/12/23

    //Sorting and Pagination

    @Override
    public List<PostDto> getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                    Sort.by(sortBy).ascending():
                    Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Post> postsPage = postRepo.findAll(pageable);
        List<Post> posts = postsPage.getContent();

        List<PostDto> dtos = posts.stream().map(p -> mapToDto(p)).collect(Collectors.toList());
        return dtos;
    }


    //07/12/23

    //Update Post

    @Override
    public PostDto updatePost(long postid, PostDto postDto) {
        Post post = postRepo.findById(postid).orElseThrow(
                () -> new ResourceNotFoundException("Post is not found by id:" + postid)
        );

        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());

        Post savedPost = postRepo.save(post);
        PostDto dto = mapToDto(savedPost);
        return dto;
    }


    PostDto mapToDto(Post post){
        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());

        return dto;
    }


}
