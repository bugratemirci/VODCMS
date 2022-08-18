package com.projects.vodcms.Business;

import java.util.List;

import com.projects.vodcms.Entities.Content;

public interface IContentService {
	List<Content> getAll();

	void add(Content content);

	void update(Content content);

	void delete(Content content);

	Content getById(int id);
}
