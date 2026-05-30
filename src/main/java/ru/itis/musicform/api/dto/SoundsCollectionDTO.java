package ru.itis.musicform.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SoundsCollectionDTO {
    private Long id;
    private String name;
    private String username;
    private String license;
    private List<String> tags;
}
