package ru.itis.musicform.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.musicform.infrastructure.persistence.entity.TeamEntity;
import ru.itis.musicform.infrastructure.persistence.entity.TeamMember;
import ru.itis.musicform.infrastructure.persistence.entity.UserEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {
    Optional<TeamMember> findByUser(UserEntity user);

    List<TeamMember> findByTeam(TeamEntity team);
}
