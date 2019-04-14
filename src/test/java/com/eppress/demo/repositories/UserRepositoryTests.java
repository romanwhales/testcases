package com.eppress.demo.repositories;

import com.eppress.demo.entities.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest

public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByEmail(){
        User user = userRepository.findByEmail("admin@gmail.com");
        assertNotNull(user);
        assertThat(user.getEmail()).isEqualTo("admin@gmail.com");
        assertThat(user.getPassword()).isEqualTo("admin");

    }
}
