package faleite.xyz.back_form.domain.repository;

import faleite.xyz.back_form.domain.model.startTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface startTaskRepository extends JpaRepository<startTask, Long> {
}
