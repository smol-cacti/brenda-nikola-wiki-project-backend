package com.example.wikiProject.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticationResponse {
    @NotBlank
    private String authenticationToken;
    @NotBlank
    private String refreshToken;
    private Instant expiresAt;
    private String username;

}
