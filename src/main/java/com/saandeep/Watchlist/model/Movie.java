package com.saandeep.Watchlist.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Column(name = "movie_name", nullable = false)
    private String movieName;
    @NonNull
    @Column(name = "date_added", nullable = false)
    private LocalDate dateAdded;
    @NonNull
    @Column(name = "is_finished", nullable = false)
    private boolean isFinished;
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
