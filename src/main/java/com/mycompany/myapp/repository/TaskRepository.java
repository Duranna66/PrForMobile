package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Task getTaskByTitle(String title);


    @Override
    default <S extends Task> S saveAndFlush(S entity) {
        return entity;
    }

    @Override
    <S extends Task> S save(S entity);

    @Override
    void deleteById(Long aLong);
}
