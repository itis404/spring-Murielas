package ru.itis.musicform.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "sound_samples")
public class SoundSampleEntity extends BaseEntity {
    @Column(name = "freesound_id", unique = true, nullable = false)
    private String freesoundId;

    @Column(name = "sound_name",nullable = false)
    private String soundName;

    @Column(name = "note_name", nullable = false)
    private String noteName;

    @ManyToOne
    @JoinColumn(name = "instrument_id", nullable = false)
    private InstrumentEntity instrument;

    @Column(name = "preview_url", unique = true, nullable = false)
    private String previewURL;

    @Column(name = "audio_url", nullable = false)
    private String audioUrl;
}
