package com.example.starlight.talent;

public class TalentNotFoundException extends RuntimeException {
    public TalentNotFoundException(Long id) {
        super("Could not find talent " + id);
    }

    public TalentNotFoundException(String message) {
        super(message);
    }
}
