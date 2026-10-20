package com.se194852.mvc.repository;

import com.se194852.mvc.entity.Artifact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtifactRepository extends JpaRepository<Artifact, Long> {
    List<Artifact> findByArtifactNameContainingIgnoreCase(String name);
}