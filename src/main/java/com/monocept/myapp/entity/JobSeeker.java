package com.monocept.myapp.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "job_seekers")

@NoArgsConstructor
public class JobSeeker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Links to User entity

    @Lob
    @Column(nullable = false)
    private byte[] resume; // Resume stored as a BLOB

    @OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.ALL)
    private List<Application> applications;
}

