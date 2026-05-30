package ru.itis.musicform.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.musicform.api.dto.RegistrationDTO;
import ru.itis.musicform.exception.myexceptions.UserAlreadyExistsException;
import ru.itis.musicform.exception.myexceptions.UserNotFoundException;
import ru.itis.musicform.infrastructure.persistence.entity.InstrumentEntity;
import ru.itis.musicform.infrastructure.persistence.entity.UserEntity;
import ru.itis.musicform.infrastructure.persistence.entity.UserInstrumentLevel;
import ru.itis.musicform.infrastructure.persistence.entity.UserRole;
import ru.itis.musicform.infrastructure.persistence.repository.InstrumentRepository;
import ru.itis.musicform.infrastructure.persistence.repository.UserInstrumentLevelRepository;
import ru.itis.musicform.infrastructure.persistence.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final InstrumentRepository instrumentRepository;
    private final UserInstrumentLevelRepository uinstlevelrepository;
    private final PasswordEncoder passwordEncoder;

    public UserEntity registration(RegistrationDTO dto) {
        if (userRepository.findByUsername(dto.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException();
        }

        UserEntity user = new UserEntity();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole(UserRole.USER);

        user = userRepository.save(user);
        List<InstrumentEntity> instruments = instrumentRepository.findAll();

        for (InstrumentEntity instrument : instruments) {
            UserInstrumentLevel level = new UserInstrumentLevel();
            level.setUser(user);
            level.setInstrument(instrument);
            level.setLevel(1);
            level.setExperience(0);
            uinstlevelrepository.save(level);
        }

        return user;
    }

    public UserEntity getActiveUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        return userRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
    }
}
