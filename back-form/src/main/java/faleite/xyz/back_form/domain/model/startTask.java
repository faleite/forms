package faleite.xyz.back_form.domain.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "start_task")
public class startTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Deve estar no User
    @Column(nullable = false)
    private String name;

    // Poder ser uma entity com dados da viatura
    @Column(name = "car_register", nullable = false)
    private String carRegistration;

    // Pode/deve: ser unico, estar no user
    // unique = true
    @Column(nullable = false)
    private String circuit;

    @Column(name = "initial_km", nullable = false)
    private Integer initialKm;

    @Column(name = "num_objects", nullable = false)
    private Short numObjects;

    @Column(name = "num_collections")
    private Short numCollections = 0;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // Elaborar regra do updated
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public startTask() {
    }

    public startTask(Long id, String name, String carRegistration, String circuit, Integer initialKm, Short numObjects, Short numCollections, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.carRegistration = carRegistration;
        this.circuit = circuit;
        this.initialKm = initialKm;
        this.numObjects = numObjects;
        this.numCollections = numCollections;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarRegistration() {
        return carRegistration;
    }

    public void setCarRegistration(String carRegistration) {
        this.carRegistration = carRegistration;
    }

    public String getCircuit() {
        return circuit;
    }

    public void setCircuit(String circuit) {
        this.circuit = circuit;
    }

    public Integer getInitialKm() {
        return initialKm;
    }

    public void setInitialKm(Integer initialKm) {
        this.initialKm = initialKm;
    }

    public Short getNumObjects() {
        return numObjects;
    }

    public void setNumObjects(Short numObjects) {
        this.numObjects = numObjects;
    }

    public Short getNumCollections() {
        return numCollections;
    }

    public void setNumCollections(Short numCollections) {
        this.numCollections = numCollections;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
