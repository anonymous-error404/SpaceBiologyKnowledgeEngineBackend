package org.nasaspaceapps.spacebiologyknowledgeenginebackend.DTOs;
import java.util.List;

public class ResearchPaperCardDTO {

    private String title;
    private String summary;
    private List<String> authors;
    private String publication;
    private int year;
    private List<String> keywords;
    private String url;

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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ResearchPaperCardDTO{" +
                "title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", authors=" + authors +
                ", publication='" + publication + '\'' +
                ", year=" + year +
                ", keywords=" + keywords +
                ", url='" + url + '\'' +
                '}';
    }
}
