package com.projects.vodcms.Entities;

public class RequestWrapper {
    Content content;
    Licence licence;

    public RequestWrapper() {
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public Licence getLicence() {
        return licence;
    }

    public void setLicence(Licence licence) {
        this.licence = licence;
    }

}
