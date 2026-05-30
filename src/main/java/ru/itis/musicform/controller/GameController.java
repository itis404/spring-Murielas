package ru.itis.musicform.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.musicform.api.dto.request.AnswerRequest;
import ru.itis.musicform.api.dto.response.AnswerResponse;
import ru.itis.musicform.api.dto.response.GameRoundResponse;
import ru.itis.musicform.exception.myexceptions.GamemodeNotFoundException;
import ru.itis.musicform.exception.myexceptions.InstrumentNotFoundException;
import ru.itis.musicform.infrastructure.persistence.entity.*;
import ru.itis.musicform.infrastructure.persistence.repository.GameModeRepository;
import ru.itis.musicform.infrastructure.persistence.repository.InstrumentRepository;
import ru.itis.musicform.infrastructure.persistence.repository.UserRepository;
import ru.itis.musicform.service.GameService;
import ru.itis.musicform.service.UserService;

@Controller
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {
    private final GameService gameService;
    private final InstrumentRepository instrumentRepository;
    private final GameModeRepository gameModeRepository;
    private final UserService userService;

    @GetMapping
    public String gamePage(@RequestParam Long instrumentId, @RequestParam Long modeId, Model model) {
        InstrumentEntity instrument = instrumentRepository.findById(instrumentId).orElseThrow(InstrumentNotFoundException::new);
        GameModeEntity mode = gameModeRepository.findById(modeId).orElseThrow(GamemodeNotFoundException::new);
        UserEntity user = userService.getActiveUser();

        GameSessionEntity session = gameService.createSession(user, instrument,mode);
        SoundSampleEntity round = gameService.generateRound(instrument);

        model.addAttribute("round", round);
        model.addAttribute("mode", mode);
        model.addAttribute("instrument", instrument);
        model.addAttribute("session", session);

        return "game";
    }

    @PostMapping("/check")
    @ResponseBody
    public AnswerResponse checkAnswer(@RequestBody AnswerRequest request) {
        return gameService.checkAnswer(request);
    }

    @GetMapping("/next-round")
    @ResponseBody
    public GameRoundResponse nextRound(@RequestParam Long instrumentId) {
        InstrumentEntity instrument = instrumentRepository.findById(instrumentId).orElseThrow(InstrumentNotFoundException::new);
        SoundSampleEntity newSound = gameService.generateRound(instrument);

        return new GameRoundResponse(newSound.getId(), newSound.getNoteName(), newSound.getAudioUrl());
    }
}
