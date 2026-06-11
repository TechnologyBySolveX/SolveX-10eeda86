package com.java.real.chatEntity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "user_phone", uniqueConstraints = {
        @UniqueConstraint(columnNames = "phoneNumber")
})
public class UserPhone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Phone number is required")
    @Column(nullable = false, unique = true, length = 15)
    private String phoneNumber;

    @NotBlank(message = "Name is required")
    private String name;

    // Optional (for WhatsApp-like features)
    private boolean online;

    private String status; // e.g. "Hey there! I'm using chat"

    // ================= Getters & Setters =================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}