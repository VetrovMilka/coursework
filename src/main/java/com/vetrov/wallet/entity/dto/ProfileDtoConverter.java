package com.vetrov.wallet.entity.dto;

import com.vetrov.wallet.entity.Profile;
import com.vetrov.wallet.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;

@Component
@RequiredArgsConstructor
public class ProfileDtoConverter {

    public Profile fromDto(ProfileDto profile, User user) {
        return Profile.builder()
                .user(user)
                .firstName(profile.getFirstName())
                .lastName(profile.getLastName())
                .email(profile.getEmail())
                .balance(BigDecimal.ZERO)
                .createdDate(Instant.now())
                .build();
    }
}
