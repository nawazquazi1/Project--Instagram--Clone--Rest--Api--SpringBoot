package com.instagram.clone.restApi.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@Data
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "follower")
    private User follower;

    //    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "following")
    private User following;

}


