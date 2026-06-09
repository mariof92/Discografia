package com.mario.Github.Discografia;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titolo;
    private int anno;
    private int numeroTracce;
    @ManyToOne
    @JoinColumn(name = "gruppo_id")
    @JsonBackReference
    private Gruppo gruppo;
}
