package study.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import study.dto.Users;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByEmail(String email);
}
