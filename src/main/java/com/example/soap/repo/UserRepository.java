package com.example.soap.repo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import com.example.soap.user.User;

import org.springframework.stereotype.Component;

@Component
public class UserRepository {

    private static Map<Long, User> users = new HashMap<>();
    
    @PostConstruct
    public void loadData() {
        User user1 = new User();
        user1.setId(1);
        user1.setName("deepesh");
        user1.setMobile("1234567890");
        user1.setEmail("example@mail.com");
        users.put(user1.getId(), user1);

        User user2 = new User();
        user2.setId(2);
        user2.setName("deepu");
        user2.setMobile("1234567890");
        user2.setEmail("example@mail.com");
        users.put(user2.getId(), user2);
    }

    public User getUserById(Long id) {
        return users.get(id);
    }

    public List<User> getAllUser() {
        return users.values().stream().collect(Collectors.toList());
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

}
