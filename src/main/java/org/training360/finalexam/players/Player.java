package org.training360.finalexam.players;

import lombok.*;
import org.training360.finalexam.teams.Team;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "players")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private LocalDate birthDate;

    @NonNull
    @Enumerated(EnumType.STRING)
    private PositionType position;

    @ManyToOne
    private Team team;
}
