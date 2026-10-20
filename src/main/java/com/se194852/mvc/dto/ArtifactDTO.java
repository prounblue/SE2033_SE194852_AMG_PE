package com.se194852.mvc.dto;

import com.se194852.mvc.entity.Artifact;
import com.se194852.mvc.entity.Category;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO for {@link com.se194852.mvc.entity.Artifact}
 */
public class ArtifactDTO implements Serializable {
    private final Integer id;
    @NotNull
    @Size(max = 6)
    private final String artifactCode;
    @NotNull
    @Size(max = 200)
    private final String artifactName;
    @NotNull
    private final BigDecimal estimatedValue;
    @NotNull
    private final Integer ageYears;
    @NotNull
    private final LocalDate acquisitionDate;
    @NotNull
    @Size(max = 10)
    private final String status;

    private Category category;

    public static ArtifactDTO convertEntityToDTO(Artifact artifact) {
        return new ArtifactDTO(
                artifact.getId(),
                artifact.getArtifactCode(),
                artifact.getArtifactName(),
                artifact.getEstimatedValue(),
                artifact.getAgeYears(),
                artifact.getAcquisitionDate(),
                artifact.getStatus(),
                artifact.getCategory()
        );
    }

    public ArtifactDTO(Integer id, String artifactCode, String artifactName, BigDecimal estimatedValue, Integer ageYears, LocalDate acquisitionDate, String status, Category category) {
        this.id = id;
        this.artifactCode = artifactCode;
        this.artifactName = artifactName;
        this.estimatedValue = estimatedValue;
        this.ageYears = ageYears;
        this.acquisitionDate = acquisitionDate;
        this.status = status;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getAcquisitionDate() {
        return acquisitionDate;
    }

    public Integer getAgeYears() {
        return ageYears;
    }

    public BigDecimal getEstimatedValue() {
        return estimatedValue;
    }

    public String getArtifactName() {
        return artifactName;
    }

    public String getArtifactCode() {
        return artifactCode;
    }
}