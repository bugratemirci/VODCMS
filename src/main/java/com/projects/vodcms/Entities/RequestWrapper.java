package com.projects.vodcms.Entities;

import java.util.List;

public class RequestWrapper {
    Content content;
    List<Licence> licence;

    public RequestWrapper() {
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public List<Licence> getLicence() {
        return this.licence;
    }

    public void setLicence(List<Licence> licence) {
        this.licence = licence;
    }

}
