package com.vetrov.wallet.controller;

import com.vetrov.wallet.entity.dto.ProfileDto;
import com.vetrov.wallet.entity.dto.UserDto;
import com.vetrov.wallet.exception.RegisterException;
import com.vetrov.wallet.service.ProfileService;
import com.vetrov.wallet.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class RegisterController {
    private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
    private final ProfileService profileService;
    private final RegisterService registerService;

    @GetMapping("/register")
    public String register() {
        logger.info("Call for register page");
        return "register";
    }

    @PostMapping("/register")
    public String addUser(
            UserDto userDto,
            ProfileDto profileDto,
            @RequestParam String passwordConfirm,
            Model model
    ) {
        try {
            registerService.registerUser(userDto, profileDto, passwordConfirm);
        } catch (RegisterException e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
        model.addAttribute("message", "Now confirm your email!");

        return "login";
    }

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code) {
        boolean isActivated = profileService.activateProfile(code);
        model.addAttribute("isActivated", isActivated);

        if (isActivated) {
            model.addAttribute("message", "Your account is now activated!");
            logger.info("Account is now activated");

        } else {
            model.addAttribute("message", "Activation code is not found!");
            logger.warn("Account was not activated");
        }

        return "info";
    }
}
