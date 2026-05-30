package ru.itis.musicform.exception.myexceptions;

public class GameSessionNotFoundException extends RuntimeException {
    public GameSessionNotFoundException() {
        super("Game Session not found");
    }
}