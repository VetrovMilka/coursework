package com.vetrov.wallet.entity.dto;

import com.vetrov.wallet.entity.User;
import lombok.Data;

import java.io.Serializable;

/**
 * A dto for the {@link User} entity
 */
@Data
public class UserDto implements Serializable {
    private final Long id;
    private final String username;
    private final String password;
}