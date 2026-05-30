package ru.itis.musicform.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.musicform.infrastructure.persistence.entity.InstrumentEntity;
import ru.itis.musicform.infrastructure.persistence.entity.SoundSampleEntity;

import java.util.List;


@Repository
public interface SoundSampleRepository extends JpaRepository<SoundSampleEntity, Long> {
    List<SoundSampleEntity> findByInstrument(InstrumentEntity instrument);

}
