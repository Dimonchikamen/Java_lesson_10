package dimonchikamen.ex1.service;

import dimonchikamen.ex1.entity.Profile;
import dimonchikamen.ex1.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;

    public Profile loadProfileByUsername(String username) throws UsernameNotFoundException {
        var optionalUser = profileRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            log.info("{}", optionalUser.get());
            return optionalUser.get();
        } else {
            throw new UsernameNotFoundException(username);
        }
    }

    public void save(Profile profile) {
        profileRepository.save(profile);
    }
}
