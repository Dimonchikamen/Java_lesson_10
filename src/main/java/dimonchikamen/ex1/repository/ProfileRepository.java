package dimonchikamen.ex1.repository;

import dimonchikamen.ex1.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByUsername(String username);

}

