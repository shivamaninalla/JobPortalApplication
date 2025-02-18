package com.monocept.myapp.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "interviews")

@NoArgsConstructor

public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "application_id", nullable = false)
    private Application application;

    @Column(nullable = false)
    private LocalDateTime interviewDate;

    @Column(nullable = false)
    private String location; // Online or Office Location

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InterviewStatus status; // SCHEDULED, COMPLETED, CANCELLED
}

