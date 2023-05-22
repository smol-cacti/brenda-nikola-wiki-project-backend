package com.example.wikiProject.service;


import com.example.wikiProject.dto.RegisterRequest;
import com.example.wikiProject.model.NotificationEmail;
import com.example.wikiProject.model.User;
import com.example.wikiProject.model.VerificationToken;
import com.example.wikiProject.repository.UserRepository;
import com.example.wikiProject.repository.VerificationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthService
{
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final VerificationTokenRepository verificationTokenRepository;
    private final MailService mailService;

    @Transactional
    public void signup(RegisterRequest registerRequest)
    {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setCreated(Instant.now());
        user.setEnabled(false);

        userRepository.save(user);
        String token = generateVerificationToken(user);
        mailService.sendMail( new NotificationEmail(
                "Please activate your wiki account",
                user.getEmail(),
                "Thank you for signing up to this wiki, please click the following authentication link to activate your account: "+
                "http://localhost:8080/api/auth/accountVerification" + token));
    }

    private String generateVerificationToken(User user)
    {
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(user);

        verificationTokenRepository.save(verificationToken);
        return token;
    }
}