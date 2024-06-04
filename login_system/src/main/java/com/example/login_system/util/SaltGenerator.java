package com.example.login_system.util;

import java.security.SecureRandom;
import java.util.Base64;

public class SaltGenerator
{
    private static final int SALT_LENGTH = 16;
    public String generateSalt()
    {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }
}
