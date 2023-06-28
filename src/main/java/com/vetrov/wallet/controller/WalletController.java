package com.vetrov.wallet.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class WalletController {
    @GetMapping("/")
    public String hello() {
        return "index";
    }
}
