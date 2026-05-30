package ru.itis.musicform.mapper;

import org.springframework.stereotype.Component;
import ru.itis.musicform.api.dto.request.CreateSoundRequest;
import ru.itis.musicform.api.dto.response.SoundResponseDTO;
import ru.itis.musicform.infrastructure.persistence.entity.SoundSampleEntity;

@Component
public class SoundMapper {
    public SoundResponseDTO toDTO(SoundSampleEntity entity) {
        if (entity == null) {
            return null;
        }

        return SoundResponseDTO.builder()
                .id(entity.getId())
                .soundName(entity.getSoundName())
                .noteName(entity.getNoteName())
                .previewURL(entity.getAudioUrl())
                .instrumentName(entity.getInstrument().getName())
                .build();
    }

    public SoundSampleEntity toEntity(CreateSoundRequest request) {
        SoundSampleEntity entity = new SoundSampleEntity();

        entity.setFreesoundId(request.getFreesoundId());
        entity.setSoundName(request.getSoundName());
        entity.setNoteName(request.getNoteName());
        entity.setAudioUrl(request.getAudioUrl());

        return entity;
    }
}
