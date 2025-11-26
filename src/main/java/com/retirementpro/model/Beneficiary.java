package com.retirementpro.model;

import jakarta.persistence.*;

@Entity
public class Beneficiary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    private Double monthlyBenefit;

    public Beneficiary() {}

    public Beneficiary(String firstName, String lastName, String ssn, Double benefit) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = ssn;
        this.monthlyBenefit = benefit;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getSocialSecurityNumber() { return socialSecurityNumber; }
    public void setSocialSecurityNumber(String ssn) { this.socialSecurityNumber = ssn; }
    public Double getMonthlyBenefit() { return monthlyBenefit; }
    public void setMonthlyBenefit(Double benefit) { this.monthlyBenefit = benefit; }
}
