package com.projects.vodcms.DataAccess;

import java.util.List;

import com.projects.vodcms.Entities.User;

public interface IUserDal {
	List<User> getAll();

	void add(User user);

	void update(User user);

	void delete(User user);

	User getById(int id);


}
