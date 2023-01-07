package com.projects.vodcms.controller;

import com.projects.vodcms.entities.Licence;
import com.projects.vodcms.service.LicenseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/licences")
@AllArgsConstructor
@CrossOrigin("*")
public class LicenseController {
    private final LicenseService licenseService;

    @GetMapping
    public ResponseEntity<List<Licence>> getAll() {
        return ResponseEntity.ok(licenseService.getAll());
    }

    @PostMapping
    public ResponseEntity<Long> add(@RequestBody Licence licence) {
        return ResponseEntity.ok(licenseService.add(licence));
    }

    @PutMapping
    public ResponseEntity<Long> update(@RequestBody Licence licence, @RequestParam("id") Long id) {
        return ResponseEntity.ok(licenseService.update(licence, id));
    }

    @DeleteMapping
    public ResponseEntity<Long> delete(@RequestParam("id") Long id) {
        return ResponseEntity.ok(licenseService.delete(id));
    }

    @GetMapping("/getById")
    public ResponseEntity<Licence> getById(@RequestParam("id") Long id) {
        return ResponseEntity.ok(licenseService.getById(id));
    }
}
