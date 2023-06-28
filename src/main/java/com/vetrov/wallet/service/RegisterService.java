package com.vetrov.wallet.service;

import com.vetrov.wallet.entity.Profile;
import com.vetrov.wallet.entity.User;
import com.vetrov.wallet.entity.dto.ProfileDto;
import com.vetrov.wallet.entity.dto.ProfileDtoConverter;
import com.vetrov.wallet.entity.dto.UserDto;
import com.vetrov.wallet.entity.dto.UserDtoConverter;
import com.vetrov.wallet.exception.RegisterException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RegisterService {
    private static final Logger logger = LoggerFactory.getLogger(RegisterService.class);
    private final UserDtoConverter userDtoConverter;
    private final ProfileDtoConverter profileDtoConverter;
    private final UserService userService;
    private final ProfileService profileService;


    public void registerUser(UserDto userDto, ProfileDto profileDto, String passwordConfirm) {
        User user = userDtoConverter.fromDto(userDto);
        Profile profile = profileDtoConverter.fromDto(profileDto, user);

        if (userService.existsUserByUsername(user.getUsername())) {
            logger.error("User not added, because user {} already exists", user.getUsername());
            throw new RegisterException("User already exists!");
        } else if (profileService.existsProfileByEmail(profile.getEmail())) {
            logger.error("User not added, because email {} exists", profile.getEmail());
            throw new RegisterException("Email already registered!");
        } else if (!Objects.equals(user.getPassword(), passwordConfirm)) {
            logger.error("User not added, because passwords not matching");
            throw new RegisterException("Passwords don't match!");
        }

        userService.add(user);
        profileService.add(profile);
    }
}
