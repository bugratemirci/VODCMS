package com.projects.vodcms.Entities;

import java.util.List;

public class ContentDTO {
    private Content content;
    private List<Licence> licences;

    public ContentDTO(Content content, List<Licence> licences) {
        this.content = content;
        this.licences = licences;
    }

    public ContentDTO() {
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public List<Licence> getLicences() {
        return licences;
    }

    public void setLicences(List<Licence> licences) {
        this.licences = licences;
    }

}
