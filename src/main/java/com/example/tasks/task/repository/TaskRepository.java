package com.example.tasks.task.repository;

import com.example.tasks.task.models.Task;
import com.example.tasks.models.BillableTask;
import com.example.tasks.models.InternalTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    // Buscar todas las tareas
    List<Task> findByStatus(boolean status);

    // Buscar todas las tareas que vencen
    List<Task> findByDueDateBefore(java.time.LocalDate dueDate);

    // Buscar todas las BillableTask
    @Query("SELECT b FROM BillableTask b")
    List<BillableTask> findAllBillableTasks();

    // Buscar todas las InternalTask
    @Query("SELECT i FROM InternalTask i")
    List<InternalTask> findAllInternalTasks();
}
