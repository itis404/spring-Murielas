package ru.itis.musicform.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.musicform.api.dto.RegistrationDTO;
import ru.itis.musicform.service.UserService;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/registration")
    public String registerPage(Model model) {
        model.addAttribute("registrationDto", new RegistrationDTO());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("registrationDto") RegistrationDTO dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.registration(dto);

        return "redirect:/login";
    }


    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}
