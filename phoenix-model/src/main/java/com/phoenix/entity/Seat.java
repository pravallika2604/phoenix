package com.phoenix.entity;

import com.phoenix.enums.SeatCategory;
import jakarta.persistence.*;

@Entity
@Table(name = "seats", uniqueConstraints = @UniqueConstraint(columnNames = {"show_id", "row_number", "seat_number"}))
public class Seat extends BaseEntity {
    private int rowNumber;
    private int seatNumber;
    private String status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "show_id", nullable = false)
    private Show show;
    @Enumerated(EnumType.STRING)
    private SeatCategory category;
}
