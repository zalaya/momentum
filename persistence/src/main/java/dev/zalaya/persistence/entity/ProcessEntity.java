package dev.zalaya.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "processes", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name", "path"})
})
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

    @CreationTimestamp
    @Column(name = "first_seen", nullable = false, updatable = false)
    private LocalDateTime firstSeen;

    @UpdateTimestamp
    @Column(name = "last_seen", nullable = false)
    private LocalDateTime lastSeen;

    @Column(name = "occurrences", nullable = false)
    private Integer occurrences = 1;

}
