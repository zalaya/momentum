package dev.zalaya.acquisition.infrastructure.persistence.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "processes")
public class ProcessEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "pid", nullable = false)
    private Integer pid;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "path", nullable = false, length = 510)
    private String path;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = false;

    @CreationTimestamp
    @Column(name = "first_seen", nullable = false, updatable = false)
    private LocalDateTime firstSeen;

    @UpdateTimestamp
    @Column(name = "last_seen", nullable = false)
    private LocalDateTime lastSeen;

    @Column(name = "occurrences", nullable = false)
    private Integer occurrences = 1;

}