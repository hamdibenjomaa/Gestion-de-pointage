package com.example.GestionDePointage.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class pointage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPointage;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat
    private Date datePointage;

    @ManyToOne
    private Employe employe ;
}
