package org.nasaspaceapps.spacebiologyknowledgeenginebackend.Services;

import org.nasaspaceapps.spacebiologyknowledgeenginebackend.DTOs.ResearchPaperCardDTO;
import org.nasaspaceapps.spacebiologyknowledgeenginebackend.Entities.KnowledgeTable;
import org.nasaspaceapps.spacebiologyknowledgeenginebackend.Repositories.KnowledgeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResearchPaperService {

    private final KnowledgeRepository knowledgeRepository;

    public ResearchPaperService(KnowledgeRepository knowledgeRepository) {
        this.knowledgeRepository = knowledgeRepository;
    }

    public List<ResearchPaperCardDTO> getResearchPaperCards() {

        List<ResearchPaperCardDTO> researchPaperCardDTOList = new ArrayList<>();
        List<KnowledgeTable> allPapers =  knowledgeRepository.findAll();

        for(KnowledgeTable paper: allPapers) {
            ResearchPaperCardDTO  researchPaperCardDTO = new ResearchPaperCardDTO();
            researchPaperCardDTO.setTitle(paper.getTitle());
            researchPaperCardDTO.setSummary(paper.getSummary());
            researchPaperCardDTO.setPublication(paper.getPublication());
            researchPaperCardDTO.setAuthors(paper.getAuthors());
            researchPaperCardDTO.setKeywords(paper.getKeywords());
            researchPaperCardDTO.setYear(paper.getYear());
            researchPaperCardDTO.setUrl(paper.getUrl());
            researchPaperCardDTOList.add(researchPaperCardDTO);
        }

        return  researchPaperCardDTOList;
    }
}
