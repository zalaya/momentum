package dev.zalaya.acquisition.infrastructure.persistence.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "process_history", indexes = {
    @Index(name = "idx_process_id", columnList = "process_id"),
    @Index(name = "idx_created_at", columnList = "created_at")
})
public class ProcessHistoryTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "process_id", nullable = false)
    private ProcessesTable process;

    @Column(name = "usage", nullable = false)
    private Double usage;

    @Column(name = "threads", nullable = false)
    private Integer threads;

    @Column(name = "memory", nullable = false)
    private Double memory;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

}
