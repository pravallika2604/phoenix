package com.phoenix.entity;

import com.phoenix.enums.SeatCategory;
import jakarta.persistence.*;

@Entity
@Table(name = "seat_category_show_prices", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"category", "show_id"})
})
public class SeatCategoryShowPrice extends BaseEntity {
    private Double price;
    @Enumerated(EnumType.STRING)
    private SeatCategory category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "show_id", nullable = false)
    private Show show;
}
