package com.monocept.myapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "locations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String state; // Karnataka, Maharashtra, etc.

    @Column(nullable = false)
    private String city; // Bangalore, Mumbai, Chennai, etc.
}

