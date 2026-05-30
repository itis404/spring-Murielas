package ru.itis.musicform.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.musicform.api.dto.request.CreateInstrumentRequest;
import ru.itis.musicform.infrastructure.persistence.entity.Note;
import ru.itis.musicform.infrastructure.persistence.repository.InstrumentRepository;
import ru.itis.musicform.infrastructure.persistence.repository.SoundSampleRepository;
import ru.itis.musicform.service.FreesoundService;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final InstrumentRepository instrumentRepository;
    private final SoundSampleRepository soundRepository;

    @GetMapping
    public String adminPage(Model model) {
        model.addAttribute("instruments", instrumentRepository.findAll());
        model.addAttribute("sounds",soundRepository.findAll());
        return "admin";
    }
}
