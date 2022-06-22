package com.springboot.api;

import com.springboot.api.model.User;
import com.springboot.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
//public class FilmApiApplication implements CommandLineRunner {
//    public static void main(String[] args) {
//        SpringApplication.run(FilmApiApplication.class, args);
//    }
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        User user = new User();
//        user.setFirstName("Quoc");
//        user.setLastName("Viet");
//        user.setEmailId("quocviet@gmail.com");
//        user.setType("admin");
//        userRepository.save(user);
//
//        User user1 = new User();
//        user1.setFirstName("Minh");
//        user1.setLastName("Khoi");
//        user1.setEmailId("minhkhoi@gmail.com");
//        user1.setType("user");
//        userRepository.save(user1);
//
//        User user2 = new User();
//        user2.setFirstName("Duc");
//        user2.setLastName("Tien");
//        user2.setEmailId("ductien@gmail.com");
//        user2.setType("user");
//        userRepository.save(user2);
//
//        User user3 = new User();
//        user3.setFirstName("Khanh");
//        user3.setLastName("Van");
//        user3.setEmailId("khanhvan@gmail.com");
//        user3.setType("user");
//        userRepository.save(user3);
//    }
//}
@SpringBootApplication
public class FilmApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(FilmApiApplication.class, args);
    }
}

