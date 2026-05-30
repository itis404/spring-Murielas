package ru.itis.musicform.exception.myexceptions;

public class SoundsNotFoundException extends RuntimeException {
    public SoundsNotFoundException() {
        super("Sounds for this instrument not found");
    }
}