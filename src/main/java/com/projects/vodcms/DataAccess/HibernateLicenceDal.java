package com.projects.vodcms.DataAccess;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projects.vodcms.Entities.Licence;

@Repository
public class HibernateLicenceDal implements ILicenceDal {
    private EntityManager entityManager;

    @Autowired
    public HibernateLicenceDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Licence> getAll() {
        Session session = entityManager.unwrap(Session.class);
        List<Licence> licences = session.createQuery("FROM licences", Licence.class).getResultList();
        return licences;
    }

    @Override
    @Transactional
    public void add(Licence licence) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(licence);
    }

    @Override
    @Transactional
    public void update(Licence licence) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(licence);
    }

    @Override
    @Transactional
    public void delete(Licence licence) {
        Session session = entityManager.unwrap(Session.class);
        session.delete(licence);
    }

    @Override
    @Transactional
    public Licence getById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Licence licence = session.get(Licence.class, id);

        return licence;
    }

}
