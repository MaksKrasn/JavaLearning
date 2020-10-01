package org.home.repositories;

import org.home.entities.Task;
import org.springframework.data.repository.CrudRepository;

public interface TasksRepository extends CrudRepository<Task, Long> {
    Task findByTaskName(String taskName);
}
