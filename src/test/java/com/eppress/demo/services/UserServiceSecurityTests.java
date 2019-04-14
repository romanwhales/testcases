package com.eppress.demo.services;

import com.eppress.demo.entities.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceSecurityTests {
    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationContext context;

    private Authentication authentication;

    @Before
    public void init(){
        AuthenticationManager authenticationManager =
                this.context.getBean(AuthenticationManager.class);
        this.authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken("admin","admin123"));

    }

    @After
    public void close(){
        SecurityContextHolder.clearContext();
    }

    @Test(expected= AuthenticationCredentialsNotFoundException.class)
    public void deleteUserUnauthenticated(){
        userService.deleteUser(3);
    }

    @Test
    public void deleteUserAuthenticated(){
        SecurityContextHolder.getContext().setAuthentication(this.authentication);
        userService.deleteUser(3);
    }

    @Test
    @WithMockUser
    public void createUserWithMockUser(){
        User user = new User();
        user.setName("Wale");
        user.setEmail("wale@gmail.com");
        user.setPassword("wale123");

        userService.createUser(user);

    }

    @Test
    @WithMockUser(username = "admin",password="admin123",roles={"USER","ADMIN"})
    public void deleteUserAuthenticatedWithMockUser(){
        userService.deleteUser(2);
    }



}
