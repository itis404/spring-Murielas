package ru.itis.musicform.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.musicform.infrastructure.persistence.entity.InstrumentEntity;
import ru.itis.musicform.infrastructure.persistence.entity.UserEntity;
import ru.itis.musicform.infrastructure.persistence.entity.UserInstrumentLevel;

import java.util.List;
import java.util.Optional;

public interface UserInstrumentLevelRepository extends JpaRepository<UserInstrumentLevel, Long> {
    Optional<UserInstrumentLevel> findByUserAndInstrument(UserEntity user, InstrumentEntity instrument);

    List<UserInstrumentLevel> findByUser(UserEntity user);
}
