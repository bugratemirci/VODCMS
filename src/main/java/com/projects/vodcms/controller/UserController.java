package com.projects.vodcms.controller;

import com.projects.vodcms.entities.User;
import com.projects.vodcms.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
@CrossOrigin("*")
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @PostMapping
    public ResponseEntity<Long> add(@RequestBody User user) {
        return ResponseEntity.ok(userService.add(user));
    }

    @PutMapping
    public ResponseEntity<Long> update(@RequestBody User user, @RequestParam("id") Long id) {
        return ResponseEntity.ok(userService.update(user, id));
    }

    @DeleteMapping
    public ResponseEntity<Long> delete(@RequestParam("id") Long id) {
        return ResponseEntity.ok(userService.delete(id));
    }

    @GetMapping("/findById")
    public ResponseEntity<User> findById(@RequestParam("id") Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }
}
