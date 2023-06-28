package com.vetrov.wallet.repository;

import com.vetrov.wallet.entity.Profile;
import com.vetrov.wallet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    boolean existsProfileByEmail(String email);

    Optional<Profile> findByUser(User user);

    Profile findByActivationCode(String code);
}