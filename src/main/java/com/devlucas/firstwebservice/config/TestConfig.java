package com.devlucas.firstwebservice.config;

import com.devlucas.firstwebservice.model.User;
import com.devlucas.firstwebservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "tst", "tst@gmail.com", "3263324363", "372844348374");
        User u2 = new User(null, "teste", "teste@gmail.com", "326343346263", "372434848374");

        userRepository.saveAll(Arrays.asList(u1,u2));
    }
}
