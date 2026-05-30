package ru.itis.musicform.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.musicform.api.dto.InstrumentDTO;
import ru.itis.musicform.infrastructure.persistence.entity.InstrumentEntity;
import ru.itis.musicform.infrastructure.persistence.repository.InstrumentRepository;

import java.util.List;

@RestController
@RequestMapping("/api/instruments")
@RequiredArgsConstructor
public class InstrumentApiController {
    private final InstrumentRepository instrumentRepository;

    @GetMapping
    public List<InstrumentDTO> getAll() {
        return instrumentRepository.findAll()
                .stream()
                .map(i -> {
                    InstrumentDTO dto = new InstrumentDTO();
                    dto.setId(i.getId());
                    dto.setName(i.getName());
                    return dto;
                })
                .toList();
    }
}
