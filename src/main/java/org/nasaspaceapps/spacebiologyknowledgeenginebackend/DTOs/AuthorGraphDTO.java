package org.nasaspaceapps.spacebiologyknowledgeenginebackend.DTOs;

import java.util.List;

public class AuthorGraphDTO {

    private String name;
    private List<String> papers;
    private List<String> urls;
    private List<String> researchArea;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPapers() {
        return papers;
    }

    public void setPapers(List<String> papers) {
        this.papers = papers;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public List<String> getResearchArea() {
        return researchArea;
    }

    public void setResearchArea(List<String> researchArea) {
        this.researchArea = researchArea;
    }

    @Override
    public String toString() {
        return "AuthorGraphDTO{" +
                "name='" + name + '\'' +
                ", papers=" + papers +
                ", urls=" + urls +
                ", researchArea=" + researchArea +
                '}';
    }
}
