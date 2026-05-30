package ru.itis.musicform.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.itis.musicform.api.dto.SoundsCollectionDTO;
import ru.itis.musicform.api.dto.request.CreateInstrumentRequest;
import ru.itis.musicform.api.dto.request.CreateSoundRequest;
import ru.itis.musicform.api.dto.request.UpdateInstrumentRequest;
import ru.itis.musicform.api.dto.response.InstrumentResponseDTO;
import ru.itis.musicform.exception.myexceptions.InstrumentNotFoundException;
import ru.itis.musicform.infrastructure.persistence.entity.InstrumentEntity;
import ru.itis.musicform.infrastructure.persistence.repository.InstrumentRepository;
import ru.itis.musicform.service.FreesoundService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminApiController {
    private final FreesoundService freesoundService;
    private final InstrumentRepository instrumentRepository;

    @GetMapping("/search")
    @Operation(summary = "Получение звуков из Freesound")
    public List<SoundsCollectionDTO> search(@RequestParam String query) {
        return freesoundService
                .search(query)
                .getResults();
    }

    @PostMapping("/instrument")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Создание/добавление инструмента в нашу бд")
    public void createInstrument(@Valid @RequestBody CreateInstrumentRequest request) {
        InstrumentEntity instrument = new InstrumentEntity();
        instrument.setName(request.getName());
        instrument.setDescription(request.getDescription());

        instrumentRepository.save(instrument);
    }

    @PutMapping("/instrument/{id}")
    @Operation(summary = "Обновление инструмента по id")
    public InstrumentResponseDTO updateInstrument(@PathVariable Long id, @Valid @RequestBody UpdateInstrumentRequest request) {
        InstrumentEntity instrument = instrumentRepository.findById(id).orElseThrow(() -> new InstrumentNotFoundException());

        instrument.setName(request.getName());
        instrument.setDescription(request.getDescription());

        InstrumentEntity updated = instrumentRepository.save(instrument);
        return new InstrumentResponseDTO(updated.getId(), updated.getName(), updated.getDescription());
    }

    @DeleteMapping("/instrument/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Удаление инструмента по id")
    public void deleteInstrument(@PathVariable Long id) {
        InstrumentEntity instrument = instrumentRepository.findById(id).orElseThrow(() -> new InstrumentNotFoundException());

        instrumentRepository.delete(instrument);
    }

    @GetMapping("/instruments")
    @Operation(summary = "Получение всех инструментов")
    public List<InstrumentResponseDTO> getAllInstruments() {
        return instrumentRepository.findAll()
                .stream()
                .map(instr -> new InstrumentResponseDTO(instr.getId(), instr.getName(), instr.getDescription()))
                .collect(Collectors.toList());
    }
}
