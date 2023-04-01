package com.projects.vodcms.service.implementation;

import com.projects.vodcms.entities.User;
import com.projects.vodcms.repository.UserRepository;
import com.projects.vodcms.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Long add(User user) {
        return userRepository.save(user).getId();
    }

    @Override
    public Long update(User user, Long id) {
        User tempUser = userRepository.findUserById(id);

        tempUser.setUsername(user.getUsername());
        tempUser.setPassword(user.getPassword());
        tempUser.setEmail(user.getEmail());

        return id;
    }

    @Override
    public Long delete(Long id) {
        userRepository.deleteById(id);
        return id;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findUserById(id);
    }
}
