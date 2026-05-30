package ru.itis.musicform.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.musicform.infrastructure.persistence.entity.GameModeEntity;

public interface GameModeRepository extends JpaRepository<GameModeEntity, Long> {
    GameModeEntity findByModeName(String modeName);
}
