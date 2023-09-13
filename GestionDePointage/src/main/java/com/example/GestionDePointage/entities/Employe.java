package com.example.GestionDePointage.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmploye;
    private String nomEmploye;
    private int idCard;

    @JsonIgnore
    @OneToMany(mappedBy ="employe")
    private List<pointage> pointageList;

}
