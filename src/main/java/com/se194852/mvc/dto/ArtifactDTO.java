package com.se194852.mvc.dto;

import com.se194852.mvc.entity.Artifact;
import com.se194852.mvc.entity.Category;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO for {@link com.se194852.mvc.entity.Artifact}
 */
public class ArtifactDTO implements Serializable {
    private final Integer id;
    @NotBlank(message = "Artifact Code is mandatory")
    @Pattern(regexp = "^[A-Z]{3}\\d{3}$", message = "Must start with 3 uppercase letters followed by 3 digits (e.g., ART101)")
    private String artifactCode;

    @NotBlank(message = "Artifact Name is mandatory")
    @Size(max = 200, message = "Max length 200")
    private String artifactName;

    @NotNull(message = "Category is mandatory")
    private Integer categoryId;

    @NotNull(message = "Estimated Value is mandatory")
    @DecimalMin(value = "0.01", message = "Must be a number greater than 0")
    private BigDecimal estimatedValue;

    @NotNull(message = "Age is mandatory")
    @Min(value = 1, message = "Must be a positive integer (greater than 0)")
    private Integer ageYears;

    @NotNull(message = "Acquisition Date is mandatory")
    @PastOrPresent(message = "Must be a valid past or present date")
    private LocalDate acquisitionDate;

    @NotBlank(message = "Status is mandatory")
    private String status;

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