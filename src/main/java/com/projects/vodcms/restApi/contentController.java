package com.projects.vodcms.restApi;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.projects.vodcms.Business.IContentService;
import com.projects.vodcms.Business.ILicencesService;
import com.projects.vodcms.Entities.Content;
import com.projects.vodcms.Entities.ContentDTO;
import com.projects.vodcms.Entities.Licence;
import com.projects.vodcms.Entities.RequestWrapper;

@RestController
@RequestMapping("/api/contents")
public class contentController {
	private IContentService contentService;
	private ILicencesService licencesService;

	@Autowired
	public contentController(IContentService contentService, ILicencesService licencesService) {
		this.contentService = contentService;
		this.licencesService = licencesService;
	}

	@GetMapping("/")
	@CrossOrigin
	public List<Content> get() {
		return contentService.getAll();
	}

	@PostMapping("/add")
	@CrossOrigin
	public void add(@RequestBody RequestWrapper requestWrapper) {
		Content content = requestWrapper.getContent();
		requestWrapper.getLicence().forEach(licenceId -> {
			Licence licence = licencesService.getById(licenceId.getId());
			content.getLicences().add(licence);
		});
		contentService.add(content);
	}

	@PostMapping("/update")
	@CrossOrigin
	public void update(@RequestBody Content content) {
		contentService.update(content);
	}

	@PostMapping("/delete")
	@CrossOrigin
	public void delete(@RequestBody Content content) {
		System.out.println("x");
		contentService.delete(content);
	}

	@GetMapping("/{id}")
	@CrossOrigin
	public Content getById(@PathVariable int id) {
		return contentService.getById(id);
	}

	@GetMapping("/contentLicences/{id}")
	@CrossOrigin
	public ContentDTO getByIdDTO(@PathVariable int id) {
		ContentDTO contentDTO = new ContentDTO();
		Content content = contentService.getById(id);
		contentDTO.setContent(content);
		contentDTO.setLicences(content.getLicences());
		return contentDTO;
	}

}
