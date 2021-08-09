package org.training360.finalexam.players;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PlayerService {

    private final ModelMapper modelMapper;

    private final PlayerRepository repository;

    public List<PlayerDTO> listAll() {
        return repository.findAll().stream().map(item -> modelMapper.map(item, PlayerDTO.class))
                .collect(Collectors.toList());
    }

    public PlayerDTO create(CreatePlayerCommand command) {
        Player item = new Player(command.getName(), command.getBirthDate(), command.getPosition());
        repository.save(item);
        return modelMapper.map(item, PlayerDTO.class);
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
