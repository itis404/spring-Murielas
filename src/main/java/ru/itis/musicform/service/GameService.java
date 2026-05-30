package ru.itis.musicform.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.musicform.api.dto.request.AnswerRequest;
import ru.itis.musicform.api.dto.response.AnswerResponse;
import ru.itis.musicform.exception.myexceptions.GameSessionNotFoundException;
import ru.itis.musicform.exception.myexceptions.InstrumentNotFoundException;
import ru.itis.musicform.exception.myexceptions.SoundNotFoundException;
import ru.itis.musicform.exception.myexceptions.SoundsNotFoundException;
import ru.itis.musicform.infrastructure.persistence.entity.*;
import ru.itis.musicform.infrastructure.persistence.repository.GameModeRepository;
import ru.itis.musicform.infrastructure.persistence.repository.GameSessionRepository;
import ru.itis.musicform.infrastructure.persistence.repository.SoundSampleRepository;
import ru.itis.musicform.infrastructure.persistence.repository.UserInstrumentLevelRepository;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class GameService {
    private final SoundSampleRepository soundSampleRepository;
    private final UserInstrumentLevelRepository userInstLevelRepository;
    private final GameSessionRepository gameSessionRepository;
    private final GameModeRepository gameModeRepository;

    public GameSessionEntity createSession(UserEntity user, InstrumentEntity instrument, GameModeEntity mode) {
        GameSessionEntity session = new GameSessionEntity();
        session.setUser(user);
        session.setInstrument(instrument);
        session.setGameMode(mode);
        session.setScore(0L);

        return gameSessionRepository.save(session);
    }

    public SoundSampleEntity generateRound(InstrumentEntity instrument) {
        List<SoundSampleEntity> sounds = soundSampleRepository.findByInstrument(instrument);

        if (sounds.isEmpty()) {
            throw new SoundsNotFoundException();
        }

        Random random = new Random();

        return sounds.get(random.nextInt(sounds.size()));
    }

    public AnswerResponse checkAnswer(AnswerRequest request) {
        SoundSampleEntity sound = soundSampleRepository.findById(request.getSoundId()).orElseThrow();
        boolean correct = sound.getNoteName().equalsIgnoreCase(request.getSelectedNote());
        GameSessionEntity session = gameSessionRepository.findById(request.getSessionId()).orElseThrow(GameSessionNotFoundException::new);

        if (correct) {
            session.setScore(session.getScore() + 10);
            gameSessionRepository.save(session);
        }

        UserInstrumentLevel level = userInstLevelRepository.findByUserAndInstrument(session.getUser(), session.getInstrument()).orElseThrow(InstrumentNotFoundException::new);

        if (correct) {
            level.setExperience(level.getExperience() + 10);
        } else {
            level.setExperience(level.getExperience() + 2);
        }

        if (level.getExperience() >= 100) {
            level.setLevel(level.getLevel() + 1);
            level.setExperience(0);
        }

        userInstLevelRepository.save(level);

        return new AnswerResponse(correct, session.getScore());
    }

}
