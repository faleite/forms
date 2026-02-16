package faleite.xyz.back_form.api.controller;

import faleite.xyz.back_form.domain.dto.startTaskCreateRequest;
import faleite.xyz.back_form.domain.dto.startTaskResponse;
import faleite.xyz.back_form.domain.service.startTaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/start")
public class startTaskController {

    private final startTaskService service;

    public startTaskController(startTaskService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<startTaskResponse> saveStartTask(@RequestBody @Valid startTaskCreateRequest request) {
        startTaskResponse created = service.saveStartTask(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}
