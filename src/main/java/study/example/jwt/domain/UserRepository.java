package study.example.jwt.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Boolean existsByUsername(String username);

    UserEntity findByUsername(String username);
}