package org.nasaspaceapps.spacebiologyknowledgeenginebackend.Services;

import org.nasaspaceapps.spacebiologyknowledgeenginebackend.DTOs.AuthorGraphDTO;
import org.nasaspaceapps.spacebiologyknowledgeenginebackend.DTOs.PaperDTO;
import org.nasaspaceapps.spacebiologyknowledgeenginebackend.DTOs.PaperGraphDTO;
import org.nasaspaceapps.spacebiologyknowledgeenginebackend.DTOs.PublicationGraphDTO;
import org.nasaspaceapps.spacebiologyknowledgeenginebackend.Entities.KnowledgeTable;
import org.nasaspaceapps.spacebiologyknowledgeenginebackend.Repositories.KnowledgeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class KnowledgeGraphService {

    private final KnowledgeRepository knowledgeRepository;

    public KnowledgeGraphService(KnowledgeRepository knowledgeRepository) {
        this.knowledgeRepository = knowledgeRepository;
    }

    public List<AuthorGraphDTO> getAuthorsWithPapers() {
        List<Object[]> rows = knowledgeRepository.findAllAuthorsWithTheirPapersRaw();

        // Grouping
        Map<String, List<PaperDTO>> grouped = new HashMap<>();
        for (Object[] row : rows) {
            String author = (String) row[0];
            String title = (String) row[1];
            String url = (String) row[2];

            grouped.computeIfAbsent(author, k -> new ArrayList<>())
                    .add(new PaperDTO(title, url));
        }

        // Convert map to list of DTOs
        List<AuthorGraphDTO> result = new ArrayList<>();
        for (Map.Entry<String, List<PaperDTO>> entry : grouped.entrySet()) {
            result.add(new AuthorGraphDTO(entry.getKey(), entry.getValue()));
        }

        return result;
    }

    public List<PublicationGraphDTO> getPublicationsWithPapers() {
        List<Object[]> rows = this.knowledgeRepository.findAllPublicationsWithTheirPapersRaw();

        // Group by publication
        Map<String, List<PaperDTO>> grouped = new HashMap<>();
        for (Object[] row : rows) {
            String publication = (String) row[0];
            String title = (String) row[1];
            String url = (String) row[2];

            grouped.computeIfAbsent(publication, k -> new ArrayList<>())
                    .add(new PaperDTO(title, url));
        }

        // Convert to DTO list
        List<PublicationGraphDTO> result = new ArrayList<>();
        for (Map.Entry<String, List<PaperDTO>> entry : grouped.entrySet()) {
            result.add(new PublicationGraphDTO(entry.getKey(), entry.getValue()));
        }

        return result;
    }

    public List<Object[]> getResearchAreasWithCount() {
        return this.knowledgeRepository.countOccurrencesByResearchArea();
    }

    public PaperGraphDTO getPaperGraph(int paperId) {
        List<Object[]> rows = this.knowledgeRepository.findPaperWithKeywords(paperId);

        if (rows.isEmpty()) {
            throw new RuntimeException("Paper not found");
        }

        PaperGraphDTO dto = new PaperGraphDTO();
        List<String> keywords = new ArrayList<>();

        for (Object[] row : rows) {
            if (dto.getTitle() == null) {
                dto.setTitle((String) row[1]);
                dto.setUrl((String) row[2]);
                dto.setPublication((String) row[3]);
                dto.setResearchArea((String) row[4]);
            }

            if (row[5] != null) {
                keywords.add((String) row[5]);
            }
        }

        dto.setKeywords(keywords);
        System.out.println(dto);
        return dto;
    }

}
