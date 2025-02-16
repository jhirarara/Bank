package com.example.bank.model;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="createdAt", nullable=false,updatable=false)
    private LocalDateTime createdAt;
    @Column(name="updatedAt", nullable=false)
    private LocalDateTime updatedAt;

@PrePersist
    protected void BaseEntity() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();

    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
   }
   public LocalDateTime getUpdatedAt() {
        return updatedAt;
   }
@PreUpdate
   protected void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
   }


   protected BaseEntity(){

    }
}
