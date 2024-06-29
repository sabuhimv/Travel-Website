package org.example.traveler.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tours")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String price;

//    @Temporal(TemporalType.DATE)
//    private Date departDate;
//
//    @Temporal(TemporalType.DATE)
//    private Date returnDate;

    private int duration;
    private int maxParticipants;
    private String tourImage;
//
//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
//    @JoinTable(
//            name = "tour_destinations",
//            joinColumns = {@JoinColumn(name = "tour_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "destination_id", referencedColumnName = "id")}
//    )
//    private List<Destination> destinations;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "guide_id", referencedColumnName = "id")
//    private Guide guide;
}
