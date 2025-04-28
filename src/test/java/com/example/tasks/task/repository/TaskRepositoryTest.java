package com.example.tasks.task.repository;

import com.example.tasks.models.BillableTask;
import com.example.tasks.models.InternalTask;
import com.example.tasks.task.models.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void testSaveAndFindByStatus() {
        Task task = new InternalTask("Complete report", LocalDate.now().plusDays(5), false);

        taskRepository.save(task);

        List<Task> incompleteTasks = taskRepository.findByStatus(false);

        assertThat(incompleteTasks).isNotEmpty();
        assertThat(incompleteTasks.get(0).isStatus()).isFalse();
    }

    @Test
    void testFindByDueDateBefore() {
        Task task = new InternalTask("Submit proposal", LocalDate.now().plusDays(2), true);

        taskRepository.save(task);

        List<Task> tasksDueSoon = taskRepository.findByDueDateBefore(LocalDate.now().plusDays(3));

        assertThat(tasksDueSoon).isNotEmpty();
        assertThat(tasksDueSoon.get(0).getDueDate()).isBefore(LocalDate.now().plusDays(3));
    }

    @Test
    void testFindAllBillableTasks() {
        Task billableTask = new BillableTask("Consulting work", LocalDate.now().plusDays(10), false, 150.0);

        taskRepository.save(billableTask);

        List<? extends Task> billableTasks = taskRepository.findAllBillableTasks();

        assertThat(billableTasks).isNotEmpty();
        assertThat(billableTasks.get(0)).isInstanceOf(BillableTask.class);
    }

    @Test
    void testFindAllInternalTasks() {
        Task internalTask = new InternalTask("Team Meeting", LocalDate.now().plusDays(3), true);

        taskRepository.save(internalTask);

        List<? extends Task> internalTasks = taskRepository.findAllInternalTasks();

        assertThat(internalTasks).isNotEmpty();
        assertThat(internalTasks.get(0)).isInstanceOf(InternalTask.class);
    }
}

