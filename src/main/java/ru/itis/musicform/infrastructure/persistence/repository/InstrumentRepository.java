package ru.itis.musicform.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.musicform.infrastructure.persistence.entity.InstrumentEntity;

public interface InstrumentRepository extends JpaRepository<InstrumentEntity, Long> {

    InstrumentEntity findByName(String name);
}
