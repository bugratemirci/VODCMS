package com.projects.vodcms.restApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.vodcms.Business.ILicencesService;
import com.projects.vodcms.Entities.Licence;

@RestController
@RequestMapping("/api/licences")
public class licenceController {
    private ILicencesService licencesService;

    @Autowired
    public licenceController(ILicencesService licencesService) {
        this.licencesService = licencesService;
    }

    @GetMapping("/")
    @CrossOrigin
    public List<Licence> get() {
        return licencesService.getAll();
    }

    @PostMapping("/add")
    @CrossOrigin
    public void add(@RequestBody Licence licence) {
        licencesService.add(licence);
    }

    @PostMapping("/update")
    @CrossOrigin
    public void update(@RequestBody Licence licence) {
        licencesService.update(licence);
    }

    @PostMapping("/delete")
    @CrossOrigin
    public void delete(@RequestBody Licence licence) {
        licencesService.delete(licence);
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public Licence getById(@PathVariable int id) {
        return licencesService.getById(id);
    }
}
