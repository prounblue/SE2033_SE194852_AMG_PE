package com.se194852.mvc.service.impl;

import com.se194852.mvc.entity.Artifact;
import com.se194852.mvc.entity.Category;
import com.se194852.mvc.repository.ArtifactRepository;
import com.se194852.mvc.repository.CategoryRepository;
import com.se194852.mvc.service.ArtifactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtifactServiceImpl implements ArtifactService {

    @Autowired
    private ArtifactRepository artifactRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Artifact> getAllArtifacts() {
        return artifactRepository.findAll();
    }

    @Override
    public List<Artifact> searchByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return artifactRepository.findAll();
        }
        return artifactRepository.findAllByOrderByAcquisitionDateDesc();
    }

    @Override
    public Artifact getArtifactById(Long id) {
        return artifactRepository.findById(id).orElse(null);
    }

    @Override
    public Artifact saveArtifact(Artifact artifact) {
        return artifactRepository.save(artifact);
    }

    @Override
    public boolean deleteArtifact(Integer id) throws Exception {
        Artifact artifact = artifactRepository.findById(id).orElse(null);
        if (artifact != null) {
            if ("AC".equalsIgnoreCase(artifact.getStatus()) || "Active".equalsIgnoreCase(artifact.getStatus())) {
                throw new Exception("Cannot delete an active artifact.");
            }
            artifactRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}