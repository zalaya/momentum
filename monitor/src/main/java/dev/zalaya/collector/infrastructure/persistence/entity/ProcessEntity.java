package dev.zalaya.collector.infrastructure.persistence.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@EqualsAndHashCode(exclude = {"id", "memory"})
@Entity
@Getter
@NoArgsConstructor
@Table(name = "processes", schema = "momentum")
public class ProcessEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String path;

    @Column(nullable = false)
    private Long memory;

}
