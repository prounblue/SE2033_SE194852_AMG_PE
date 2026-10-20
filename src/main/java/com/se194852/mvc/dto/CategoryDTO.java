package com.se194852.mvc.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * DTO for {@link com.se194852.mvc.entity.Artifact}
 */
public class CategoryDTO implements Serializable {
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

    public CategoryDTO(Integer id, String artifactCode, String artifactName, BigDecimal estimatedValue, Integer ageYears, LocalDate acquisitionDate, String status) {
        this.id = id;
        this.artifactCode = artifactCode;
        this.artifactName = artifactName;
        this.estimatedValue = estimatedValue;
        this.ageYears = ageYears;
        this.acquisitionDate = acquisitionDate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public String getArtifactCode() {
        return artifactCode;
    }

    public String getArtifactName() {
        return artifactName;
    }

    public BigDecimal getEstimatedValue() {
        return estimatedValue;
    }

    public Integer getAgeYears() {
        return ageYears;
    }

    public LocalDate getAcquisitionDate() {
        return acquisitionDate;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryDTO entity = (CategoryDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.artifactCode, entity.artifactCode) &&
                Objects.equals(this.artifactName, entity.artifactName) &&
                Objects.equals(this.estimatedValue, entity.estimatedValue) &&
                Objects.equals(this.ageYears, entity.ageYears) &&
                Objects.equals(this.acquisitionDate, entity.acquisitionDate) &&
                Objects.equals(this.status, entity.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, artifactCode, artifactName, estimatedValue, ageYears, acquisitionDate, status);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "artifactCode = " + artifactCode + ", " +
                "artifactName = " + artifactName + ", " +
                "estimatedValue = " + estimatedValue + ", " +
                "ageYears = " + ageYears + ", " +
                "acquisitionDate = " + acquisitionDate + ", " +
                "status = " + status + ")";
    }
}