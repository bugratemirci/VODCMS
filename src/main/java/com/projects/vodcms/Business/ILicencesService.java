package com.projects.vodcms.Business;

import java.util.List;

import com.projects.vodcms.Entities.Licence;

public interface ILicencesService {
    List<Licence> getAll();

	void add(Licence licence);

	void update(Licence licence);

	void delete(Licence licence);

	Licence getById(int id);
}
