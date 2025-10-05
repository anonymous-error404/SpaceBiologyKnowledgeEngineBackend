package org.nasaspaceapps.spacebiologyknowledgeenginebackend.Controllers;

import org.nasaspaceapps.spacebiologyknowledgeenginebackend.DTOs.AuthorGraphDTO;
import org.nasaspaceapps.spacebiologyknowledgeenginebackend.DTOs.PaperGraphDTO;
import org.nasaspaceapps.spacebiologyknowledgeenginebackend.DTOs.PublicationGraphDTO;
import org.nasaspaceapps.spacebiologyknowledgeenginebackend.Services.KnowledgeGraphService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/knowledgegraph")
public class KnowledgeGraphController {

    private final KnowledgeGraphService knowledgeGraphService;

    public KnowledgeGraphController(KnowledgeGraphService knowledgeGraphService) {
        this.knowledgeGraphService = knowledgeGraphService;
    }

    @GetMapping("/authors")
    public ResponseEntity<List<AuthorGraphDTO>> getAllAuthorGraph() {
        return ResponseEntity.ok(this.knowledgeGraphService.getAuthorsWithPapers());
    }

    @GetMapping("/publications")
    public ResponseEntity<List<PublicationGraphDTO>> getAllPublicationGraph() {
        return ResponseEntity.ok(this.knowledgeGraphService.getPublicationsWithPapers());
    }

    @GetMapping("/researcharea")
    public ResponseEntity<List<Object[]>> getAllResearchAreaGraph() {
        return ResponseEntity.ok(this.knowledgeGraphService.getResearchAreasWithCount());
    }

    @GetMapping("/paper/{paper_id}")
    public ResponseEntity<PaperGraphDTO> getPaperGraph(@PathVariable("paper_id") int paperId) {
        return ResponseEntity.ok(this.knowledgeGraphService.getPaperGraph(paperId));
    }

}
