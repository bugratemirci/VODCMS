package com.projects.vodcms.controller;

import com.projects.vodcms.entities.Content;
import com.projects.vodcms.service.ContentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contents")
@AllArgsConstructor
@CrossOrigin("*")
public class ContentController {
    private ContentService contentService;

    @GetMapping
    public ResponseEntity<List<Content>> getAll() {
        return ResponseEntity.ok(contentService.getAll());
    }

    @PostMapping
    public ResponseEntity<Long> add(@RequestBody Content content) {
        return ResponseEntity.ok(contentService.add(content));
    }

    @PutMapping
    public ResponseEntity<Long> edit(@RequestBody Content content, @RequestParam("id") Long id) {
        return ResponseEntity.ok(contentService.edit(content, id));
    }

    @DeleteMapping
    public ResponseEntity<Long> delete(@RequestParam("id") Long id) {
        return ResponseEntity.ok(contentService.delete(id));
    }

    @GetMapping("/getById")
    public ResponseEntity<Content> getById(@RequestParam("id") Long id) {
        return ResponseEntity.ok(contentService.getById(id));
    }
}
