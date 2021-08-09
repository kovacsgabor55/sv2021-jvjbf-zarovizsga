package org.training360.finalexam.players;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query("select count(p) from Player p where p.team.id = :id and p.position = :type")
    int countPositionByTeam(@Param("id") Long id, @Param("type") PositionType type);
}
