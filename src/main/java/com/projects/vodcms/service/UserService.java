package com.projects.vodcms.service;

import com.projects.vodcms.entities.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    Long add(User user);

    Long update(User user, Long id);

    Long delete(Long id);

    User findById(Long id);
}
