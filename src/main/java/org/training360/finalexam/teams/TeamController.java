package org.training360.finalexam.teams;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.training360.finalexam.players.CreatePlayerCommand;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/teams")
public class TeamController {

    private final TeamService service;

    @GetMapping
    public List<TeamDTO> listAll() {
        return service.listAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeamDTO create(@Valid @RequestBody CreateTeamCommand command) {
        return service.create(command);
    }

    @PostMapping ("/{id}/players")
    public TeamDTO updateById(@PathVariable("id") int id, @Valid @RequestBody CreatePlayerCommand command) {
        return service.updateById(id, command);
    }

    @PutMapping("/{id}/players")
    public TeamDTO transferPlayer(@PathVariable Long id, @Valid @RequestBody UpdateWithExistingPlayerCommand command) {
        return service.confirmTeamPlayer(id, command);
    }
}
