package study.example.jwt.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "`user`")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
}
