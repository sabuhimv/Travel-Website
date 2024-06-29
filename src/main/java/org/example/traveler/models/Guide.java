package org.example.traveler.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "guides")
public class Guide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String biography;
    private String photoUrl;
    private String instagram;
    private String facebook;
    private String twitter;
    private String linkedin;
    private Boolean isDeleted = false;
    private Boolean Available = true;

//    @OneToOne(mappedBy = "guide")
//    private Tour tour;
}
