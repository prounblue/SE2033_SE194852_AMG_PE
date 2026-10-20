package com.se194852.mvc.controller;

import com.se194852.mvc.entity.Artifact;
import com.se194852.mvc.service.ArtifactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private ArtifactService artifactService;

    @GetMapping("/")
    public String index(@RequestParam(value = "searchName", required = false) String searchName, Model model) {
        model.addAttribute("artifacts", artifactService.searchByName(searchName));
        model.addAttribute("searchName", searchName);
        return "index";
    }

    @PostMapping("/search")
    public String search(@RequestParam("searchName") String searchName, Model model) {
        model.addAttribute("artifacts", artifactService.searchByName(searchName));
        model.addAttribute("searchName", searchName);
        return "index";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("artifact", new Artifact());
        model.addAttribute("categories", artifactService.getAllCategories());
        return "add";
    }

    @PostMapping("/add")
    public String saveArtifact(@ModelAttribute("artifact") Artifact artifact) {
        artifactService.saveArtifact(artifact);
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String viewArtifact(@PathVariable("id") Long id, Model model) {
        Artifact artifact = artifactService.getArtifactById(id);
        if (artifact == null) {
            return "redirect:/";
        }
        model.addAttribute("artifact", artifact);
        return "view";
    }

    @GetMapping("/delete/{id}")
    public String deleteArtifact(@PathVariable("id") Long id) {
        artifactService.deleteArtifact(id);
        return "redirect:/";
    }
}