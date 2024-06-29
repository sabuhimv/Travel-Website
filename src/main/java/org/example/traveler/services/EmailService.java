package org.example.traveler.services;

public interface EmailService {
    void sendConfirmationToken(String email,String token);
}
