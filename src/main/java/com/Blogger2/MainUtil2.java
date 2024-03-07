package com.Blogger2;

import com.Blogger2.entity.Post;
import com.Blogger2.payload.PostDto;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainUtil2 {
    public static void main(String[] args) {

        MainUtil2 mainUtil2 = new MainUtil2();

        Post p1 = new Post();
        p1.setTitle("bbb");
        p1.setId(1);


        Post p2 = new Post();
        p2.setTitle("aaa");
        p2.setId(2);


        Post p3 = new Post();
        p3.setTitle("bbb");
        p3.setId(3);

        List<Post> data = Arrays.asList(p1, p2, p3);
//        List<PostDto> collect = data.stream().map(p -> mapToDto(p)).collect(Collectors.toList());
        List<PostDto> collect = data.stream().map(mainUtil2::mapToDto).collect(Collectors.toList());

        System.out.println(collect);

    }

//    static PostDto mapToDto(Post post){
//        PostDto dto = new PostDto();
//        dto.setId(post.getId());
//        dto.setTitle(post.getTitle());
//
//        return dto;
//    }


        PostDto mapToDto(Post post){
        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());

        return dto;
    }

}
