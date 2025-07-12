package com.phoenix.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "screens")
public class Screen extends BaseEntity{
    private String name;
    @Column(name = "seat_mapping_url")
    private String seatMappingUrl;
    private int capacity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theatre_id", nullable = false)
    private Theatre theatre;
    @OneToMany(mappedBy = "screen", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Show> shows;

}
