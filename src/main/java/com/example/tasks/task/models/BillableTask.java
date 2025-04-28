package com.example.tasks.models;

import com.example.tasks.task.models.Task;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class BillableTask extends Task {

    private Double hourlyRate;

    public BillableTask() {}

    public BillableTask(String title, LocalDate dueDate, boolean status, Double hourlyRate) {
        super(title, dueDate, status);
        this.hourlyRate = hourlyRate;
    }

    // Getters and Setters
    public Double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(Double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
