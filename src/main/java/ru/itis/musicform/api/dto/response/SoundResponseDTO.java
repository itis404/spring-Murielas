package ru.itis.musicform.api.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SoundResponseDTO {
    private Long id;
    private String soundName;
    private String noteName;
    private String previewURL;
    private String instrumentName;
}
