package com.projects.vodcms.service;

import com.projects.vodcms.entities.Content;

import java.util.List;

public interface ContentService {
    List<Content> getAll();

    Long add(Content content);

    Long edit(Content content, Long id);

    Long delete(Long id);

    Content getById(Long id);

}
