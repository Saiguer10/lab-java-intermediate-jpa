package com.example.tasks.prcompany.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class Name {

    private String firstName;
    private String lastName;
    private String middleName;
    private String salutation;

    public Name() {}

    public Name(String firstName, String lastName, String middleName, String salutation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.salutation = salutation;
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getFullName() {
        StringBuilder sb = new StringBuilder();

        if (salutation != null && !salutation.isEmpty()) {
            sb.append(salutation).append(" ");
        }

        sb.append(firstName);

        if (middleName != null && !middleName.isEmpty()) {
            sb.append(" ").append(middleName);
        }

        if (lastName != null && !lastName.isEmpty()) {
            sb.append(" ").append(lastName);
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", salutation='" + salutation + '\'' +
                '}';
    }
}