package org.example.traveler.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "destinations")
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String country;
    private String city;
    private String photoUrl;

//    @ManyToMany(mappedBy = "destinations")
//    private List<Tour> tours =new ArrayList<>();
}
