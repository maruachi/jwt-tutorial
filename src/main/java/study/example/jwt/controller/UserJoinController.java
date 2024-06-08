package study.example.jwt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.example.jwt.domain.UserEntity;
import study.example.jwt.domain.UserRepository;
import study.example.jwt.dto.UserJoinDto;

@RestController
@RequiredArgsConstructor
public class UserJoinController {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @PostMapping(value = "/join")
    public UserJoinDto userJoin(@RequestBody UserJoinDto userJoinDto) {
        if (!userJoinDto.getPassword().equals(userJoinDto.getPassword2())) {
            return null;
        }

        String encodePassword = passwordEncoder.encode(userJoinDto.getPassword());

        UserEntity joinUser = userRepository.save(UserEntity.builder()
                .username(userJoinDto.getUsername())
                .password(encodePassword)
                .userRole(userJoinDto.getUserRole())
                .build());

        return userJoinDto.from(joinUser);
    }
}
