package org.nasaspaceapps.spacebiologyknowledgeenginebackend.DTOs;

import java.util.List;

public class AuthorGraphDTO {
    private String author;
    private List<PaperDTO> papers;

    public AuthorGraphDTO(String author, List<PaperDTO> papers) {
        this.author = author;
        this.papers = papers;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<PaperDTO> getPapers() {
        return papers;
    }

    public void setPapers(List<PaperDTO> papers) {
        this.papers = papers;
    }
// getters and setters
}