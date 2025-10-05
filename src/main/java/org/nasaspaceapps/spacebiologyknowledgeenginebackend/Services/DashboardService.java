package org.nasaspaceapps.spacebiologyknowledgeenginebackend.Services;

import org.nasaspaceapps.spacebiologyknowledgeenginebackend.Entities.KnowledgeTable;
import org.nasaspaceapps.spacebiologyknowledgeenginebackend.Repositories.KnowledgeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DashboardService {
    private final KnowledgeRepository knowledgeRepository;

    public DashboardService(KnowledgeRepository knowledgeRepository) {
        this.knowledgeRepository = knowledgeRepository;
    }

    public List<Integer[]> getYearsCount() {
        return knowledgeRepository.countOccurrencesByYear();
    }

    public List<String[]> getMostViewedPapers(){
        return knowledgeRepository.findTopTenMostViewed();
    }
}
