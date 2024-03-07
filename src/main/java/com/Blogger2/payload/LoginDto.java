package com.Blogger2.payload;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class LoginDto {
    private String usernameOrEmail;
    private String password;
}
