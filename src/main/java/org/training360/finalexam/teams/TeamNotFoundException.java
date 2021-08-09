package org.training360.finalexam.teams;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class TeamNotFoundException extends AbstractThrowableProblem {
    public TeamNotFoundException(long id) {
        super(URI.create("teamss/not-found"),
                "Not Found",
                Status.NOT_FOUND,
                "Team not found: " + id
        );
    }
}
