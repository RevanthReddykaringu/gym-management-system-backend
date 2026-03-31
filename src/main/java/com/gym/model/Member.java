package com.gym.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;

    private LocalDate joinDate;
    private LocalDate expiryDate;

    private String plan;     // ✅ NEW (1 Month, 3 Months, etc.)
    private String status;   // ACTIVE / EXPIRED

    // ✅ Default Constructor
    public Member() {}

    // ✅ Parameterized Constructor
    public Member(Long id, String name, String phone, LocalDate joinDate, LocalDate expiryDate, String plan, String status) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.joinDate = joinDate;
        this.expiryDate = expiryDate;
        this.plan = plan;
        this.status = status;
    }

    // ✅ Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
