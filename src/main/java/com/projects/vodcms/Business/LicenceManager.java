package com.projects.vodcms.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projects.vodcms.DataAccess.ILicenceDal;
import com.projects.vodcms.Entities.Licence;

@Service
public class LicenceManager implements ILicencesService {
    private ILicenceDal licenceDal;

    @Autowired
    public LicenceManager(ILicenceDal licenceDal) {
        this.licenceDal = licenceDal;
    }

    @Override
    @Transactional
    public List<Licence> getAll() {
        return this.licenceDal.getAll();
    }

    @Override
    @Transactional
    public void add(Licence licence) {
        this.licenceDal.add(licence);
    }

    @Override
    @Transactional
    public void update(Licence licence) {
        this.licenceDal.update(licence);
    }

    @Override
    @Transactional
    public void delete(Licence licence) {
        this.licenceDal.delete(licence);
    }

    @Override
    @Transactional
    public Licence getById(int id) {
        return this.licenceDal.getById(id);
    }

}
