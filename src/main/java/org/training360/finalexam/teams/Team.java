package org.training360.finalexam.teams;

import lombok.*;
import org.training360.finalexam.players.Player;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private List<Player> players;

    public void addPlayer(Player player) {
        player.setTeam(this);
        if (players == null) {
            players = new ArrayList<>();
        }
        players.add(player);
    }
}
