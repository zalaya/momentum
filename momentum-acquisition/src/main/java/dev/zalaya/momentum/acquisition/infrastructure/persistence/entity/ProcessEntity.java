package dev.zalaya.momentum.acquisition.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Entity
@Getter
@Table(name = "processes")
@NoArgsConstructor
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

    @Column(name = "cpu", nullable = false)
    private Double cpu;

    @Column(name = "memory", nullable = false)
    private Long memory;

    @Column(name = "threads", nullable = false)
    private Integer threads;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

}
