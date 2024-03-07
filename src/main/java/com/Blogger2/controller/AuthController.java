package com.Blogger2.controller;

import com.Blogger2.entity.Role;
import com.Blogger2.entity.User;
import com.Blogger2.payload.JWTAuthResponse;
import com.Blogger2.payload.LoginDto;
import com.Blogger2.payload.SignUpDto;
import com.Blogger2.repository.RoleRepository;
import com.Blogger2.repository.UserRepository;
import com.Blogger2.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/{signup}")
    public ResponseEntity<?> signupForm(@RequestBody SignUpDto signUpDto){

        if(userRepo.existsByEmail(signUpDto.getEmail())){
            return new ResponseEntity<>("Email id already exists :"+signUpDto.getEmail(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (userRepo.existsByUsername(signUpDto.getUsername())){
            return new ResponseEntity<>("Username not exist:"+signUpDto.getUsername(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

        User user = new User();
        user.setName(signUpDto.getName());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        user.setUsername(signUpDto.getUsername());

        Role roles = roleRepository.findByName("ROLE_ADMIN").get();
        user.setRoles(Collections.singleton (roles));

        userRepo.save(user);

        return new ResponseEntity<>("User Registrered Successfully", HttpStatus.OK);
    }


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<JWTAuthResponse> authenticateUser(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        //get taken form takenProvider
        String token = tokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new JWTAuthResponse(token));
    }


//    @PostMapping("/signin")
//    public ResponseEntity<JWTAuthResponse> authenticateUser(@RequestBody LoginDto loginDto){
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//                loginDto.getUsernameOrEmail(), loginDto.getPassword()));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String token = tokenProvider.generateToken(authentication);
//        return ResponseEntity.ok(new JWTAuthResponse(token));
//    }


}
