package com.springboot.api;

import com.springboot.api.model.Actor;
import com.springboot.api.model.Film;
import com.springboot.api.model.User;
import com.springboot.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
    public class FilmApiApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(FilmApiApplication.class, args);
    }

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setFirstName("Quoc");
        user.setLastName("Viet");
        user.setEmailId("quocviet@gmail.com");
        user.setType("admin");
        userRepository.save(user);
    }
}
//@SpringBootApplication
//public class FilmApiApplication {
//    public static void main(String[] args) {
//        SpringApplication.run(FilmApiApplication.class, args);
//    }
//}

