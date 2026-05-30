package ru.itis.musicform.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "game_mode")
public class GameModeEntity extends BaseEntity {
    @Column(name = "gamemode_name", unique = true, nullable = false)
    private String modeName;

    private String description;
}
