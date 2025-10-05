package org.nasaspaceapps.spacebiologyknowledgeenginebackend.DTOs;

import java.util.List;

public class PaperGraphDTO {

    private String title;
    private List<String> keywords;
    private String url;
    private String publication;
    private String researchArea;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public String getResearchArea() {
        return researchArea;
    }

    public void setResearchArea(String researchArea) {
        this.researchArea = researchArea;
    }

    public String toString() {
        return "PaperGraphDTO{" +
                "title='" + title + '\'' +
                ", keywords=" + keywords +
                ", url='" + url + '\'' +
                ", publication='" + publication + '\'' +
                ", researchArea='" + researchArea + '\'' +
                '}';
    }
}
