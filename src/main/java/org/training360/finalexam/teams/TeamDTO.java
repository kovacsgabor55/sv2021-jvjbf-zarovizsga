package org.training360.finalexam.teams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.training360.finalexam.players.Player;
import org.training360.finalexam.players.PlayerDTO;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TeamDTO {
    private long id;
    private String name;
    private Set<PlayerDTO> players;
}
