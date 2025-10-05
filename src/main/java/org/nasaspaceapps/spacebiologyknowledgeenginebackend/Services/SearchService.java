package org.nasaspaceapps.spacebiologyknowledgeenginebackend.Services;

import org.nasaspaceapps.spacebiologyknowledgeenginebackend.DTOs.ResearchPaperCardDTO;
import org.nasaspaceapps.spacebiologyknowledgeenginebackend.Entities.KnowledgeTable;
import org.nasaspaceapps.spacebiologyknowledgeenginebackend.Repositories.KnowledgeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    private final KnowledgeRepository knowledgeRepository;

    public SearchService(KnowledgeRepository knowledgeRepository) {
        this.knowledgeRepository = knowledgeRepository;
    }

    public List<Object[]> getSearchResult(String searchTerm) {
        System.out.println(this.knowledgeRepository.searchByTerm(searchTerm));
        return this.knowledgeRepository.searchByTerm(searchTerm);
    }

    public ResearchPaperCardDTO getResearchPaperCard(int paper_id) {
        KnowledgeTable kt = knowledgeRepository.findByPaperId(paper_id);

        ResearchPaperCardDTO rp = new ResearchPaperCardDTO();

        rp.setPaper_id(paper_id);
        rp.setUrl(kt.getUrl());
        rp.setTitle(kt.getTitle());
        rp.setPublication(kt.getPublication());
        rp.setPublication(kt.getPublication());
        rp.setAuthors(kt.getAuthors());
        rp.setKeywords(kt.getKeywords());
        rp.setSummary(kt.getSummary());

        return rp;
    }


}
