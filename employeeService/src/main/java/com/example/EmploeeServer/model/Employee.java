package com.example.EmploeeServer.model;

public class Employee {

        private Long id;
        private Long personalId;
        private String firstName;
        private String lastName;
        private String email;


//Constructor
    public Employee(Long id, Long personalId, String firstName, String lastName, String email) {
        this.id = id;
        this.personalId=personalId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

//Getters:

    public Long getId() {
        return id;
    }

    public Long getPersonalId() {
        return personalId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

//Setters:

    public void setId(Long id) {
        this.id = id;
    }
    public void setPersonalId (Long personalId){this.personalId = personalId;};
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
