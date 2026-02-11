package faleite.xyz.back_form.domain.service;

import faleite.xyz.back_form.domain.dto.startTaskCreateRequest;
import faleite.xyz.back_form.domain.dto.startTaskResponse;
import faleite.xyz.back_form.domain.mapper.startTaskMapper;
import faleite.xyz.back_form.domain.model.startTask;
import faleite.xyz.back_form.domain.repository.startTaskRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class startTaskService {

    private final startTaskRepository repository;

    public startTaskService(startTaskRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public startTaskResponse saveStartTask(@Valid startTaskCreateRequest request) {
        startTask entity = startTaskMapper.toEntity(request);
        if (entity.getNumCollections() == null) {
            entity.setNumCollections((short) 0);
        }
        entity = repository.save(entity);
        return startTaskMapper.toResponse(entity);
    }
}
