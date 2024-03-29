package com.projects.vodcms.service.implementation;

import com.projects.vodcms.entities.Content;
import com.projects.vodcms.repository.ContentRepository;
import com.projects.vodcms.service.ContentService;
import com.projects.vodcms.specification.ContentSpecification;
import com.projects.vodcms.specification.SearchCriteria;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContentServiceImp implements ContentService {
    private final ContentRepository contentRepository;

    @Override
    public List<Content> getAll() {
        return contentRepository.findAll();
    }

    @Override
    public Page<Content> getAllPageable(Integer page, Integer itemCount, String filter) {
        Pageable pageable = PageRequest.of(page, itemCount);
        ContentSpecification specification = new ContentSpecification(new SearchCriteria("contentName", ":", filter));
        return contentRepository.findAll(specification, pageable);
    }

    @Override
    public Long add(Content content) {
        return contentRepository.save(content).getId();
    }

    @Override
    public Long edit(Content content, Long id ) {
        Content tempContent = contentRepository.findContentById(id);
        System.out.println(tempContent.getContentName());
        tempContent.setContentDescription(content.getContentDescription());
        tempContent.setContentName(content.getContentName());
        tempContent.setContentStatus(content.getContentStatus());
        tempContent.setLicences(content.getLicences());
        tempContent.setContentPosterUrl(content.getContentPosterUrl());
        tempContent.setContentVideoUrl(content.getContentVideoUrl());

        return contentRepository.save(tempContent).getId();
    }

    @Override
    public Long delete(Long id) {
        contentRepository.deleteById(id);
        return id;
    }

    @Override
    public Content getById(Long id) {
        return contentRepository.findContentById(id);
    }
}
