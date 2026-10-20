package com.se194852.mvc.repository;

import com.se194852.mvc.entity.Artifact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtifactRepository extends JpaRepository<Artifact, Integer> {
    @Query("SELECT a FROM Artifact a WHERE (:keyword IS NULL OR LOWER(a.artifactName) LIKE LOWER(CONCAT('%', :keyword, '%'))) ORDER BY a.acquisitionDate DESC")
    List<Artifact> searchByNameOrderByAcquisitionDateDesc(@Param("keyword") String keyword);

    List<Artifact> findAllByOrderByAcquisitionDateDesc();

    boolean existsByArtifactCode(String artifactCode);
}