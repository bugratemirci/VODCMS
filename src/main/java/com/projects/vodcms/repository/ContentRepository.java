package com.projects.vodcms.repository;

import com.projects.vodcms.entities.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {
    Content findContentById(Long id);
}
