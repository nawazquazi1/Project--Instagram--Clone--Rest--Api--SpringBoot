package com.instagram.clone.restApi.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Data
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'default.png'")
    private String chatImage;

    private String chatName;

    private boolean isGroup;

    @ManyToOne
    private User createBy;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<User> users = new HashSet<>();

    @ManyToMany
    private Set<User> admins = new HashSet<>();


}
