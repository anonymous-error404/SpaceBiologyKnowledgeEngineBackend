package org.nasaspaceapps.spacebiologyknowledgeenginebackend.DTOs;

import java.util.List;

public class PublicationGraphDTO {
    private String publication;
    private List<PaperDTO> papers;

    public PublicationGraphDTO(String publication, List<PaperDTO> papers) {
        this.publication = publication;
        this.papers = papers;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public List<PaperDTO> getPapers() {
        return papers;
    }

    public void setPapers(List<PaperDTO> papers) {
        this.papers = papers;
    }
// getters and setters
}
