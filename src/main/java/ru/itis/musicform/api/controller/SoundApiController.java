package ru.itis.musicform.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.itis.musicform.api.dto.request.CreateSoundRequest;
import ru.itis.musicform.api.dto.response.SoundResponseDTO;
import ru.itis.musicform.api.dto.request.UpdateSoundRequest;
import ru.itis.musicform.service.SoundService;

import java.util.List;

@RestController
@RequestMapping("/api/sounds")
@RequiredArgsConstructor
public class SoundApiController {
    private final SoundService soundService;

    @GetMapping
    @Operation(summary = "Получение списка звуков из нашей бд")
    public List<SoundResponseDTO> getAllSounds() {
        return soundService.getAllSounds();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение звука по id")
    public SoundResponseDTO getOneSound(@PathVariable Long id) {
        return soundService.getSoundById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Создание/добавление звука в нашу бд")
    public SoundResponseDTO createSound(@Valid @RequestBody CreateSoundRequest request) {
        return soundService.createSound(request);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Изменение звука по id")
    public SoundResponseDTO updateSound(@PathVariable Long id, @Valid @RequestBody UpdateSoundRequest request) {
        return soundService.updateSound(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Удаление звука по id")
    public void deleteSound(@PathVariable Long id) {
        soundService.deleteSound(id);
    }
}
