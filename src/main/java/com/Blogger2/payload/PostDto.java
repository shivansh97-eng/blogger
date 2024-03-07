package com.Blogger2.payload;

//import jakarta.validation.constraints.NotEmpty;
//import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    private long id;

    @NotEmpty
    @Size(min=2,message = "keyword should be at least 2 words")
    private String title;

    @NotEmpty
    @Size(min=2,message = "keyword should be at least 2 words")
    private String description;

    @NotEmpty
    @Size(min=2,message = "keyword should be at least 2 words")
    private String content;

//    private String message;
}
