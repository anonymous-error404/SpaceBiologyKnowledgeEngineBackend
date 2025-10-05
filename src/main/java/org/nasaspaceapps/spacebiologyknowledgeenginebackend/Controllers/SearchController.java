package org.nasaspaceapps.spacebiologyknowledgeenginebackend.Controllers;

import org.nasaspaceapps.spacebiologyknowledgeenginebackend.DTOs.ResearchPaperCardDTO;
import org.nasaspaceapps.spacebiologyknowledgeenginebackend.Services.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {

    private final SearchService service;

    public SearchController(SearchService service) {
        this.service = service;
    }

    @GetMapping("/similar/{searchTerm}")
    public ResponseEntity<List<Object[]>> getSimilarPapers(@PathVariable String searchTerm) {
         return ResponseEntity.ok(service.getSearchResult(searchTerm));
    }

    @GetMapping("/getpaper/{paper_id}")
    public ResponseEntity<ResearchPaperCardDTO> getResearchPaperCard(@PathVariable int paper_id) {
        return ResponseEntity.ok(this.service.getResearchPaperCard(paper_id));
    }

}
