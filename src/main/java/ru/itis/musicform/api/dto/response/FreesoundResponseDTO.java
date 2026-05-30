package ru.itis.musicform.api.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import ru.itis.musicform.api.dto.SoundsCollectionDTO;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FreesoundResponseDTO {
    private List<SoundsCollectionDTO> results;
}