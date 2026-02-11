package faleite.xyz.back_form.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record startTaskCreateRequest(
        @NotBlank String name,
        @NotBlank String carRegistration,
        @NotBlank String circuit,
        @NotNull Integer initialKm,
        @NotNull Short numObjects,
        Short numCollections
) {
}
