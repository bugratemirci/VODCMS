package com.projects.vodcms.service;

import com.projects.vodcms.entities.Licence;

import java.util.List;

public interface LicenseService {
    List<Licence> getAll();

    Long add(Licence licence);

    Long delete(Long id);

    Long update(Licence licence, Long id);

    Licence getById(Long id);
}
