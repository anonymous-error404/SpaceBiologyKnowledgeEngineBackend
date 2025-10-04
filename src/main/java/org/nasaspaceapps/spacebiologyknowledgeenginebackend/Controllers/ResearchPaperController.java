package org.nasaspaceapps.spacebiologyknowledgeenginebackend.Controllers;

import org.nasaspaceapps.spacebiologyknowledgeenginebackend.DTOs.ResearchPaperCardDTO;
import org.nasaspaceapps.spacebiologyknowledgeenginebackend.Services.ResearchPaperService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/researchpapers")
public class ResearchPaperController {

    ResearchPaperService researchPaperService;

    public ResearchPaperController(ResearchPaperService researchPaperService) {
        this.researchPaperService = researchPaperService;
    }

    @GetMapping("/getcards")
    public ResponseEntity<Map<String, List<ResearchPaperCardDTO>>> getCards(){
         System.out.println(researchPaperService.getResearchPaperCards());
         return ResponseEntity.ok(Collections.singletonMap("cards",researchPaperService.getResearchPaperCards()));
    }

}
