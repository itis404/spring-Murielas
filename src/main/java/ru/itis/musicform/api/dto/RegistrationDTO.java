package ru.itis.musicform.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationDTO {
    @NotBlank(message = "Заполните имя пользователя")
    @Size(min = 3, max = 20, message = "Имя должно содержать не меньше 3 символов и не больше 20 символов")
    private String username;

    @NotBlank(message = "Заполните почту")
    private String email;

    @NotBlank(message = "Заполните пароль")
    @Size(min = 6, max = 12, message = "Пароль должен содержать не меньше 6 символов и не больше 12 символов")
    private String password;
}
