package com.projects.vodcms.restApi;

import java.util.List;

import javax.validation.constraints.AssertTrue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.vodcms.Business.IUserService;
import com.projects.vodcms.Entities.User;

import at.favre.lib.crypto.bcrypt.BCrypt;
import at.favre.lib.crypto.bcrypt.LongPasswordStrategies;
import at.favre.lib.crypto.bcrypt.LongPasswordStrategy;
import at.favre.lib.crypto.bcrypt.BCrypt.Version;

@RestController
@RequestMapping("/api/users")
public class userController {
    private IUserService iUserService;

    @Autowired
    public userController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @GetMapping("/")
    @CrossOrigin
    public List<User> get() {
        return iUserService.getAll();
    }

    @PostMapping("/add")
    @CrossOrigin
    public void add(@RequestBody User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("12345");
        user.setPassword(password);
        iUserService.add(user);
    }

    @PostMapping("/login")
    @CrossOrigin
    public User auth(@RequestBody User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        for (User u : this.iUserService.getAll()) {
            if (user.getUsername().equals(u.getUsername())
                    && passwordEncoder.matches(user.getPassword(), u.getPassword())) {
                return iUserService.getById(u.getId());
            }
        }
        return null;
    }

}
