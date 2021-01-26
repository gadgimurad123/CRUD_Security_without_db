package com.gaz.web.dao;

import com.gaz.web.entity.Role;
import com.gaz.web.entity.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserDaoImpl implements UserDao {

    private final Map<String, User> userMap = new HashMap<>();

    {
        userMap.put("admin",
                new User(1L, "admin", "adminov", 2002, "admin@mail.ru", "admin",
                        Collections.singleton(new Role(1L, "ROLE_ADMIN"))));
        userMap.put("ivan",
                new User(2L, "ivan", "ivanov", 1988, "ivan@mail.ru", "ivan",
                        Collections.singleton(new Role(1L, "ROLE_USER"))));
        userMap.put("sasha",
                new User(3L, "sasha", "sashaev", 1999, "sasha@mail.ru", "sasha",
                        Collections.singleton(new Role(1L, "ROLE_USER"))));
        userMap.put("elena",
                new User(4L, "elena", "eleneva", 1989, "elena@mail.ru", "elena",
                        new HashSet<> (Arrays.asList(new Role(1L, "ROLE_ADMIN"), new Role(2L, "ROLE_USER")))));
    }

    @Override
    public User getUserByName(String name) {
        if (!userMap.containsKey(name)) {
            return null;
        }

        return userMap.get(name);
    }

    @Override
    public Map<String, User> getAllUsers() {
        return userMap;
    }

    @Override
    public void saveUser(User user) {
        userMap.put(user.getName(), user);
    }

    @Override
    public void deleteUser(String name) {
        userMap.remove(name);
    }

}
