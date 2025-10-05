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

    public List<ResearchPaperCardDTO> getResearchPaperCards(int latest) {

        List<ResearchPaperCardDTO> researchPaperCardDTOList = new ArrayList<>();

        for(KnowledgeTable paper: knowledgeRepository.findFirst10ByPaperIdGreaterThanOrderByPaperIdAsc(latest)) {
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
