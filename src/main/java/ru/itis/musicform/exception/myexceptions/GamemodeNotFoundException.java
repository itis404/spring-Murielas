package ru.itis.musicform.exception.myexceptions;

public class GamemodeNotFoundException extends RuntimeException {
    public GamemodeNotFoundException() {
        super("Gamemode not found");
    }
}