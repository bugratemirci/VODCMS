package com.projects.vodcms.service.implementation;

import com.projects.vodcms.entities.Licence;
import com.projects.vodcms.repository.LicenseRepository;
import com.projects.vodcms.service.LicenseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LicenseServiceImp implements LicenseService {
    private final LicenseRepository licenseRepository;

    @Override
    public List<Licence> getAll() {
        return licenseRepository.findAll();
    }

    @Override
    public Long add(Licence licence) {
        return licenseRepository.save(licence).getId();
    }

    @Override
    public Long delete(Long id) {
        licenseRepository.deleteById(id);
        return id;
    }

    @Override
    public Long update(Licence licence, Long id) {
        Licence tempLicense = licenseRepository.findLicenceById(id);

        tempLicense.setContents(licence.getContents());
        tempLicense.setLicenceName(licence.getLicenceName());
        tempLicense.setStartTime(licence.getStartTime());
        tempLicense.setEndTime(licence.getEndTime());

        return id;
    }

    @Override
    public Licence getById(Long id) {
        return licenseRepository.findLicenceById(id);
    }
}
