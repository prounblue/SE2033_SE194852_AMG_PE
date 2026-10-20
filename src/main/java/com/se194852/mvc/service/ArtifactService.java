package com.se194852.mvc.service;

import com.se194852.mvc.entity.Artifact;
import com.se194852.mvc.entity.Category;

import java.util.List;

public interface ArtifactService {
    List<Artifact> getAllArtifacts();
    List<Artifact> searchByName(String name);
    Artifact getArtifactById(Long id);
    Artifact saveArtifact(Artifact artifact);
    void deleteArtifact(Long id);
    List<Category> getAllCategories();
}