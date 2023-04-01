package com.projects.vodcms.service;

import com.projects.vodcms.entities.Content;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ContentService {
    List<Content> getAll();

    Page<Content> getAllPageable(Integer page, Integer itemCount, String filter);

    Long add(Content content);

    Long edit(Content content, Long id);

    Long delete(Long id);

    Content getById(Long id);

}
