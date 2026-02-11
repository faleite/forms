package faleite.xyz.back_form.domain.mapper;

import faleite.xyz.back_form.domain.dto.startTaskCreateRequest;
import faleite.xyz.back_form.domain.dto.startTaskResponse;
import faleite.xyz.back_form.domain.model.startTask;

import java.time.LocalDateTime;

public class startTaskMapper {

    public static startTask toEntity(startTaskCreateRequest request) {
        startTask startTask = new startTask();
        startTask.setName(request.name());
        startTask.setCarRegistration(request.carRegistration());
        startTask.setCircuit(request.circuit());
        startTask.setInitialKm(request.initialKm());
        startTask.setNumObjects(request.numObjects());
        startTask.setNumCollections(request.numCollections());
        startTask.setCreatedAt(LocalDateTime.now());
        startTask.setUpdatedAt(LocalDateTime.now());
        return startTask;
    }

    public static startTaskResponse toResponse(startTask startTask) {
        return new startTaskResponse(
                startTask.getId(),
                startTask.getName(),
                startTask.getCarRegistration(),
                startTask.getCircuit(),
                startTask.getInitialKm(),
                startTask.getNumObjects(),
                startTask.getNumCollections(),
                startTask.getCreatedAt(),
                startTask.getUpdatedAt()
        );
    }
}
