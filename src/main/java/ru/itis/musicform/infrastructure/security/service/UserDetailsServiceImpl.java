package ru.itis.musicform.infrastructure.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itis.musicform.infrastructure.persistence.entity.UserEntity;
import ru.itis.musicform.infrastructure.persistence.repository.UserRepository;

import java.util.Optional;

@Service("customUserDetailService")
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userOptional = userRepository.findByUsername(username);
        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("Неизвестный пользователь");
        }

        UserEntity user = userOptional.get();

        return new UserDetailsImpl(user);
    }

}
