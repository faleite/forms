package faleite.xyz.back_form.domain.dto;

import java.time.LocalDateTime;

public record startTaskResponse(
        Long id,
        String name,
        String carRegistration,
        String circuit,
        Integer initialKm,
        Short numObjects,
        Short numCollections,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
