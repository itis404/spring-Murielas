package ru.itis.musicform.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "instruments")
public class InstrumentEntity extends BaseEntity {
    @Column(name = "instrument_name", unique = true, nullable = false)
    private String name;

    private String description;

    @OneToMany(mappedBy = "instrument", cascade = CascadeType.ALL)
    private List<UserInstrumentLevel> userLevels = new ArrayList<>();

    @OneToMany(mappedBy = "instrument", cascade = CascadeType.ALL)
    private List<SoundSampleEntity> instrumentsSounds = new ArrayList<>();

    @OneToMany(mappedBy = "instrument", cascade = CascadeType.ALL)
    private List<GameSessionEntity> gameSessions = new ArrayList<>();
}
