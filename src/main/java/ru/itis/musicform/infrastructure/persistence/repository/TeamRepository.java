package ru.itis.musicform.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.itis.musicform.infrastructure.persistence.entity.TeamEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<TeamEntity, Long> {
    Optional<TeamEntity> findByTeamName(String teamName);

    @Query("""
    select t
    from TeamEntity t
    where 
    (
      select count(tm)
      from TeamMember tm
      where tm.team = t
    ) < 10
    """)
    List<TeamEntity> findCorrectTeams();
}
