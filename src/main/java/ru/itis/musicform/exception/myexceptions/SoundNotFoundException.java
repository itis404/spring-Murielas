package ru.itis.musicform.exception.myexceptions;

public class SoundNotFoundException extends RuntimeException {
    public SoundNotFoundException(Long id) {
        super("Sound not found with id = " + id);
    }
}
