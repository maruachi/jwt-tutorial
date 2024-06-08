package study.example.jwt.dto;

import lombok.*;
import study.example.jwt.domain.UserEntity;
import study.example.jwt.domain.UserRole;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserJoinDto {
    private String username;
    private String password;
    private String password2;
    private UserRole userRole;

    public static UserJoinDto from(UserEntity joinUser) {
        return UserJoinDto.builder()
                .username(joinUser.getUsername())
                .userRole(joinUser.getUserRole())
                .build();
    }
}

