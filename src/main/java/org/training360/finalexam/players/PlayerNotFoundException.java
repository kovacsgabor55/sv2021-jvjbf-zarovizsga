package org.training360.finalexam.players;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class PlayerNotFoundException extends AbstractThrowableProblem {
    public PlayerNotFoundException(long id) {
        super(URI.create("players/not-found"),
                "Not Found",
                Status.NOT_FOUND,
                "Player not found: " + id
        );
    }
}
