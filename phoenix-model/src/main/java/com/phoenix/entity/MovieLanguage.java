package com.phoenix.entity;

import com.phoenix.enums.Language;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "movie_languages", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"movie_id", "language"})
})
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieLanguage extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(name = "language", nullable = false)
    private Language language;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;
}
