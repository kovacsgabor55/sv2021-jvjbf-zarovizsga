package org.training360.finalexam.teams;

import lombok.*;
import org.training360.finalexam.players.Player;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teams")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @OneToMany(mappedBy = "team", cascade = CascadeType.PERSIST)
    private Set<Player> players;

    public void addPlayer(Player player) {
        player.setTeam(this);
        if (players == null) {
            players = new HashSet<>();
        }
        players.add(player);
    }
}
