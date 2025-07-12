package com.phoenix.entity;


import jakarta.persistence.*;

import java.util.List;

@Table(name = "theatres")
@Entity
public class Theatre extends BaseEntity {
    private String name;
    private String email;
    private String phone;
    private String location;
    private String city;
    private String pincode;

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Screen> screens;

}
