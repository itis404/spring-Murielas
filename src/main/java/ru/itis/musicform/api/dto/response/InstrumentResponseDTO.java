package ru.itis.musicform.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class InstrumentResponseDTO {
    private Long id;
    private String name;
    private String description;
}
