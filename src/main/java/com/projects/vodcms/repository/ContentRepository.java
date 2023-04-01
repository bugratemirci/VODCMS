package com.projects.vodcms.repository;

import com.projects.vodcms.entities.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long>, PagingAndSortingRepository<Content, Long>, JpaSpecificationExecutor<Content> {
    Content findContentById(Long id);
}
