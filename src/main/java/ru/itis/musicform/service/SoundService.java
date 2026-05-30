package ru.itis.musicform.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.musicform.api.dto.request.CreateSoundRequest;
import ru.itis.musicform.api.dto.response.SoundResponseDTO;
import ru.itis.musicform.api.dto.request.UpdateSoundRequest;
import ru.itis.musicform.exception.myexceptions.InstrumentNotFoundException;
import ru.itis.musicform.exception.myexceptions.SoundNotFoundException;
import ru.itis.musicform.infrastructure.persistence.entity.InstrumentEntity;
import ru.itis.musicform.infrastructure.persistence.entity.SoundSampleEntity;
import ru.itis.musicform.infrastructure.persistence.repository.InstrumentRepository;
import ru.itis.musicform.infrastructure.persistence.repository.SoundSampleRepository;
import ru.itis.musicform.mapper.SoundMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SoundService {
    private final SoundSampleRepository soundRepository;
    private final InstrumentRepository instrumentRepository;
    private final SoundMapper soundMapper;

    public List<SoundResponseDTO> getAllSounds() {
        return soundRepository.findAll()
                .stream()
                .map(soundMapper::toDTO)
                .toList();
    }

    public SoundResponseDTO getSoundById(Long id) {
        SoundSampleEntity sound = soundRepository.findById(id).orElseThrow(() -> new SoundNotFoundException(id));

        return soundMapper.toDTO(sound);
    }

    public SoundResponseDTO createSound(CreateSoundRequest request) {
        InstrumentEntity instrument = instrumentRepository.findById(request.getInstrumentId()).orElseThrow(InstrumentNotFoundException::new);
        SoundSampleEntity entity = new SoundSampleEntity();

        entity.setFreesoundId(request.getFreesoundId());
        entity.setSoundName(request.getSoundName());
        entity.setNoteName(request.getNoteName());
        entity.setAudioUrl(request.getAudioUrl());
        entity.setInstrument(instrument);

        return soundMapper.toDTO(soundRepository.save(entity));
    }

    public SoundResponseDTO updateSound(Long id, UpdateSoundRequest request) {
        SoundSampleEntity entity = soundRepository.findById(id).orElseThrow(() -> new SoundNotFoundException(id));

        entity.setSoundName(request.getSoundName());
        entity.setNoteName(request.getNoteName());
        entity.setAudioUrl(request.getAudioUrl());

        SoundSampleEntity updated = soundRepository.save(entity);

        return soundMapper.toDTO(updated);
    }

    public void deleteSound(Long id) {
        SoundSampleEntity entity = soundRepository.findById(id).orElseThrow(() -> new SoundNotFoundException(id));

        soundRepository.delete(entity);
    }
}
