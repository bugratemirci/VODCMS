package com.projects.vodcms.DataAccess;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projects.vodcms.Entities.Content;

@Repository
public class HibernateContentDal implements IContentDal {
	private EntityManager entityManager;

	@Autowired
	public HibernateContentDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<Content> getAll() {
		Session session = entityManager.unwrap(Session.class);
		List<Content> contents = session.createQuery("FROM contents", Content.class).getResultList();

		return contents;
	}

	@Override
	@Transactional
	public void add(Content content) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(content);
	}

	@Override
	@Transactional
	public void update(Content content) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(content);
	}

	@Override
	@Transactional
	public void delete(Content content) {
		Session session = entityManager.unwrap(Session.class);
		Content contentToDelete = session.get(Content.class, content.getId());
		session.delete(contentToDelete);
	}

	@Override
	public Content getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Content content = session.get(Content.class, id);

		return content;
	}

}
