package com.projects.vodcms.repository;

import com.projects.vodcms.entities.Licence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenseRepository extends JpaRepository<Licence, Long> {
    Licence findLicenceById(Long id);
}
