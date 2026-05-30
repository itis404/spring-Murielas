package ru.itis.musicform.infrastructure.persistence.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.musicform.api.dto.PlayerLeaderboardDTO;
import ru.itis.musicform.api.dto.TeamLeaderboardDTO;
import ru.itis.musicform.infrastructure.persistence.entity.GameSessionEntity;
import ru.itis.musicform.infrastructure.persistence.entity.UserEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface GameSessionRepository extends JpaRepository<GameSessionEntity, Long> {
    @Query("""
    select new ru.itis.musicform.api.dto.PlayerLeaderboardDTO(
        g.user.username,
        sum(g.score)
    ) from GameSessionEntity g 
    where g.creationDt >= :weekStart
    group by 
        g.user.id,
        g.user.username
    order by sum(g.score) desc
    """)
    List<PlayerLeaderboardDTO> getTopPlayersWeek(LocalDateTime weekStart, Pageable pageable);

    @Query("""
    select new ru.itis.musicform.api.dto.TeamLeaderboardDTO(
        tm.team.teamName,
        sum(gs.score)
    ) from GameSessionEntity gs 
    join TeamMember tm on tm.user = gs.user
    where gs.creationDt >= :weekStart
    group by 
        tm.team.id,
        tm.team.teamName
    order by sum(gs.score) desc
    """)
    List<TeamLeaderboardDTO> getTopTeamsWeek(LocalDateTime weekStart, Pageable pageable);

    @Query("""
    select sum(g.score)
    from GameSessionEntity g
    where g.user = :user
    """)
    Optional<Long> sumUserScore(@Param("user") UserEntity user);
}
