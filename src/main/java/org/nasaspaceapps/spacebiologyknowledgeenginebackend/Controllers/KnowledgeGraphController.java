package org.nasaspaceapps.spacebiologyknowledgeenginebackend.Controllers;

import org.nasaspaceapps.spacebiologyknowledgeenginebackend.DTOs.AuthorGraphDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/knowledgegraph")
public class KnowledgeGraphController {

    @GetMapping("/authors/{authorname}")
    public AuthorGraphDTO getAuthorGraph(@PathVariable String authorname) {
          return null;
    }
}
