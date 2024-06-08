package study.example.jwt.domain;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum UserRole {
    MANAGER("MANAGER"), MASTER("MASTER");

    private final String value;

    UserRole(String value) {
        this.value = value;
    }

    public static UserRole from(String value) {
        return Arrays.stream(UserRole.values())
                .filter((role) -> role.value.equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

}
