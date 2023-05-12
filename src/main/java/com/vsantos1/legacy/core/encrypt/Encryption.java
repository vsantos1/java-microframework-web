package com.vsantos1.legacy.core.encrypt;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class Encryption {

    private final int STRENGTH;

    public Encryption(int strength) {

        this.STRENGTH = strength == 0 ? strength : 12;
    }


    public BCrypt.Hasher getEncrypt() {
        return BCrypt.withDefaults();
    }

    public BCrypt.Verifyer getVerifyer() {
        return BCrypt.verifyer();
    }

    public String generateHash(String hash) {

        return getEncrypt().hashToString(STRENGTH, hash.toCharArray());
    }

    public boolean compareHash(String hashed, String hash) {
        return getVerifyer().verify(hashed.toCharArray(), hash).verified;
    }

}
