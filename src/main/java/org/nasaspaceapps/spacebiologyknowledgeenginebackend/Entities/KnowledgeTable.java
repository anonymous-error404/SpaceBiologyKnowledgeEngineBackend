package org.nasaspaceapps.spacebiologyknowledgeenginebackend.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class KnowledgeTable {

    @Id
    private int paperId;
    @ElementCollection
    private List<String> authors;
    private String publication;
    private String title;
    private int year;
    private String url;
    @Column(columnDefinition = "TEXT")
    private String Abstract;
    @Column(columnDefinition = "TEXT")
    private String introduction;
    @Column(columnDefinition = "TEXT")
    private String methodology;
    @Column(columnDefinition = "TEXT")
    private String results;
    @Column(columnDefinition = "TEXT")
    private String conclusions;
    @Column(columnDefinition = "TEXT")
    private String summary;
    @ElementCollection
    private List<String> ref;
    @ElementCollection
    private List<String> keywords;
    @ElementCollection
    private List<String> impacts;
    @ElementCollection
    private List<String> knowledge_gaps;
    @ElementCollection
    private List<Integer> similar_papers;
    @Column(nullable = false, columnDefinition = "integer default 0")
    private Integer viewCount = 0;

    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getAbstract() {
        return Abstract;
    }

    public void setAbstract(String anAbstract) {
        Abstract = anAbstract;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getMethodology() {
        return methodology;
    }

    public void setMethodology(String methodology) {
        this.methodology = methodology;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public String getConclusions() {
        return conclusions;
    }

    public void setConclusions(String conclusions) {
        this.conclusions = conclusions;
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

    public List<String> getImpacts() {
        return impacts;
    }

    public void setImpacts(List<String> impacts) {
        this.impacts = impacts;
    }

    public List<String> getKnowledge_gaps() {
        return knowledge_gaps;
    }

    public void setKnowledge_gaps(List<String> knowledge_gaps) {
        this.knowledge_gaps = knowledge_gaps;
    }

    public List<Integer> getSimilar_papers() {
        return similar_papers;
    }

    public void setSimilar_papers(List<Integer> similar_papers) {
        this.similar_papers = similar_papers;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public List<String> getRef() {
        return ref;
    }

    public void setRef(List<String> ref) {
        this.ref = ref;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    @Override
    public String toString() {
        return "KnowledgeTable{" +
                "paperId=" + paperId +
                ", authors=" + authors +
                ", publication='" + publication + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", url='" + url + '\'' +
                ", Abstract='" + Abstract + '\'' +
                ", introduction='" + introduction + '\'' +
                ", methodology='" + methodology + '\'' +
                ", results='" + results + '\'' +
                ", conclusions='" + conclusions + '\'' +
                ", references=" + ref +
                ", keywords=" + keywords +
                ", summary='" + summary + '\'' +
                ", impacts=" + impacts +
                ", knowledge_gaps=" + knowledge_gaps +
                ", similar_papers=" + similar_papers +
                ", viewCount=" + viewCount +
                '}';
    }
}
