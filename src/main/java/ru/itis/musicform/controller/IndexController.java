package ru.itis.musicform.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.musicform.infrastructure.persistence.entity.InstrumentEntity;
import ru.itis.musicform.infrastructure.persistence.repository.GameModeRepository;
import ru.itis.musicform.infrastructure.persistence.repository.InstrumentRepository;

@Controller
@RequiredArgsConstructor
@RequestMapping("/index")
public class IndexController {
    private final InstrumentRepository instrumentRepository;
    private final GameModeRepository gameModeRepository;

    @GetMapping()
    public String index(Model model) {
        InstrumentEntity piano = instrumentRepository.findByName("Пианино");
        InstrumentEntity guitar = instrumentRepository.findByName("Гитара");
        model.addAttribute("piano", piano);
        model.addAttribute("guitar", guitar);
        model.addAttribute("mode1", gameModeRepository.findByModeName("LEARN"));
        model.addAttribute("mode2", gameModeRepository.findByModeName("HEAR"));

        return "index";
    }
}
