package ru.itis.musicform.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.musicform.infrastructure.persistence.entity.UserEntity;
import ru.itis.musicform.infrastructure.persistence.repository.UserInstrumentLevelRepository;
import ru.itis.musicform.service.UserService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {
    private final UserService userService;
    private final UserInstrumentLevelRepository levelRepository;

    @GetMapping
    public String accountPage(Model model) {
        UserEntity user = userService.getActiveUser();

        model.addAttribute("user", user);
        model.addAttribute("levels", levelRepository.findByUser(user));

        return "account";
    }
}

