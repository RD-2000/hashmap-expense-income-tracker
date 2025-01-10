package com.rd.hashmap.repository;

    import com.rd.hashmap.model.User;

    import java.util.HashMap;

public class UserRepository {
    private HashMap<String, User> users = new HashMap<>();

    public void saveUser(User user) {
        users.put(user.getUsername(), user);
    }

    public User getUser(String username) {
        return users.get(username);
    }
}

