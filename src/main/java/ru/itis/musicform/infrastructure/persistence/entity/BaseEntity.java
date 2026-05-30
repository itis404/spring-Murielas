package ru.itis.musicform.infrastructure.persistence.entity;

import jakarta.annotation.PreDestroy;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "creation_at", nullable = false, updatable = false)
    private LocalDateTime creationDt;

    @Column(name = "update_at", nullable = false)
    private LocalDateTime updateDt;

    @PrePersist
    protected void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        setCreationDt(now);
        setUpdateDt(now);
    }

    @PreUpdate
    protected void preUpdate() {
        setUpdateDt(LocalDateTime.now());
    }

}
