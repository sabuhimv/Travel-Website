package org.example.traveler.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "testimonials")
public class Testimonial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String profession;
    private String comment;
    private String photo;
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;
}
