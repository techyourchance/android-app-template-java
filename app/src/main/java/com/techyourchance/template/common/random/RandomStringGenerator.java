package com.techyourchance.template.common.random;

import java.security.SecureRandom;

import javax.inject.Inject;

public class RandomStringGenerator {

    private static final String ALPHANUMERIC = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    private static final Object LOCK = new Object();

    @Inject
    public RandomStringGenerator() {
    }

    public String getRandomAlphanumericString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for(int i = 0; i < length; i++) {
            int position;
            synchronized (LOCK) { // thread-safe protection of SecureRandom (just in case)
                position = SECURE_RANDOM.nextInt(ALPHANUMERIC.length());
            }
            sb.append(ALPHANUMERIC.charAt(position));
        }
        return sb.toString();
    }
}
