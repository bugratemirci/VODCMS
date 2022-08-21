package com.projects.vodcms.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projects.vodcms.DataAccess.IUserDal;
import com.projects.vodcms.Entities.User;

@Service
public class UserManager implements IUserService {
    private IUserDal iUserDal;

    @Autowired
    public UserManager(IUserDal iUserDal) {
        this.iUserDal = iUserDal;
    }

    @Override
    @Transactional
    public List<User> getAll() {
        return this.iUserDal.getAll();
    }

    @Override
    @Transactional
    public void add(User user) {
        this.iUserDal.add(user);

    }

    @Override
    @Transactional
    public void update(User user) {
        // TODO Auto-generated method stub

    }

    @Override
    @Transactional
    public void delete(User user) {
        // TODO Auto-generated method stub

    }

    @Override
    @Transactional
    public User getById(int id) {
        return this.iUserDal.getById(id);
    }

}
