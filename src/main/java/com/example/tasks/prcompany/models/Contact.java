package com.example.tasks.prcompany.models;

import jakarta.persistence.*;

@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Name name;

    private String title;
    private String company;

    public Contact() {}

    public Contact(Name name, String title, String company) {
        this.name = name;
        this.title = title;
        this.company = company;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name=" + name +
                ", title='" + title + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
