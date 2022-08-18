package com.projects.vodcms.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projects.vodcms.DataAccess.IContentDal;
import com.projects.vodcms.Entities.Content;

@Service
public class ContentManager implements IContentService {
	private IContentDal contentDal;
	
	@Autowired
	public ContentManager(IContentDal contentDal) {
		this.contentDal = contentDal;
	}

	@Override
	@Transactional
	public List<Content> getAll() {
		return this.contentDal.getAll();
	}

	@Override
	@Transactional
	public void add(Content content) {
		this.contentDal.add(content);
	}

	@Override
	@Transactional
	public void update(Content content) {
		this.contentDal.update(content);	
	}

	@Override
	@Transactional
	public void delete(Content content) {
		this.contentDal.delete(content);	
	}

	@Override
	@Transactional
	public Content getById(int id) {
		return this.contentDal.getById(id);
	}

}
