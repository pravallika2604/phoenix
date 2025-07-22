package com.phoenix.entity;

import com.phoenix.enums.Genre;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "movie_genres", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"movie_id", "genre"})
})
public class MovieGenre extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(name = "genre", nullable = false)
    private Genre genre;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;
}
