package ru.itis.musicform.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.itis.musicform.api.dto.response.FreesoundResponseDTO;
import ru.itis.musicform.api.dto.SoundDetailsDTO;
import ru.itis.musicform.infrastructure.persistence.entity.InstrumentEntity;
import ru.itis.musicform.infrastructure.persistence.entity.SoundSampleEntity;
import ru.itis.musicform.infrastructure.persistence.repository.SoundSampleRepository;

@Service
@RequiredArgsConstructor
public class FreesoundService {
    private final RestTemplate restTemplate;
    private final SoundSampleRepository soundRepository;

    @Value("${freesound.api.key}")
    private String apiKey;


    public FreesoundResponseDTO search(String query) {
        String url = "https://freesound.org/apiv2/search/text/?query="
                + query + "&token=" + apiKey;
        return restTemplate.getForObject(url, FreesoundResponseDTO.class);
    }

    public SoundDetailsDTO getSound(Long soundId) {
        String url = "https://freesound.org/apiv2/sounds/"
                + soundId + "/?token=" + apiKey;
        return restTemplate.getForObject(url, SoundDetailsDTO.class);
    }

    public SoundSampleEntity importSound(Long soundId, String noteName, InstrumentEntity instrument) {
        SoundDetailsDTO sound = getSound(soundId);
        SoundSampleEntity entity = new SoundSampleEntity();
        entity.setFreesoundId(String.valueOf(soundId));
        entity.setSoundName(sound.getName());
        entity.setNoteName(noteName);
        entity.setAudioUrl(sound.getPreviews().getPreviewMp3());
        entity.setInstrument(instrument);

        return soundRepository.save(entity);
    };
}
