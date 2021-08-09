package org.training360.finalexam.players;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlayerDTO {
    private long id;
    private String name;
    private LocalDate birthDate;
    private PositionType position;
}
