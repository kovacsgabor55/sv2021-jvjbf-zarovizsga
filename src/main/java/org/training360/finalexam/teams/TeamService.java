package org.training360.finalexam.teams;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.training360.finalexam.players.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TeamService {

    private final ModelMapper modelMapper;

    private final TeamRepository repository;

    private final PlayerRepository playerRepository;

    //TODO kellenek a playerek is
    public List<TeamDTO> listAll() {
        return repository.findAll().stream().map(item -> modelMapper.map(item, TeamDTO.class))
                .collect(Collectors.toList());

        //return null;
    }

    public TeamDTO create(CreateTeamCommand command) {
        Team item = new Team(command.getName());
        repository.save(item);
        return modelMapper.map(item, TeamDTO.class);
    }

    @Transactional
    public TeamDTO updateById(long id, CreatePlayerCommand command) {
        Team item = repository.findById(id)
                .orElseThrow(() -> new TeamNotFoundException(id));
        if (command.getBirthDate() != null && command.getPosition() != null) {
            Player player = new Player(command.getName(), command.getBirthDate(), command.getPosition());
            playerRepository.save(player);
            item.addPlayer(player);
        } else {
            throw new IllegalArgumentException("Player data cannot be null!");
        }
        return modelMapper.map(item, TeamDTO.class);
    }

    @Transactional
    public TeamDTO confirmTeamPlayer(Long id, UpdateWithExistingPlayerCommand command) {
        Player player = playerRepository.findById(command.getPlayerId()).orElseThrow(() -> new PlayerNotFoundException(command.getPlayerId()));
        Team item = repository.findById(id)
                .orElseThrow(() -> new TeamNotFoundException(id));
        if (player.getTeam() == null && countPosition(id, player.getPosition()) < 2) {
            item.addPlayer(player);
        }
        return modelMapper.map(item, TeamDTO.class);
    }

    private int countPosition(Long id, PositionType type) {
        return playerRepository.countPositionByTeam(id, type);
    }
}
