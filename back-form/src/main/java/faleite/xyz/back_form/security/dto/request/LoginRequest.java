package faleite.xyz.back_form.security.dto.request;

import jakarta.validation.constraints.NotEmpty;

public record LoginRequest(
       @NotEmpty(message = "Login é obrigatório") String login,
       @NotEmpty(message = "Senha é obrigatória") String password
) {
}
