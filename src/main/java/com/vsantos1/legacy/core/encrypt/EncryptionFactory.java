package com.vsantos1.legacy.core.encrypt;


public class EncryptionFactory {


    public static Encryption getInstance(int strength) {
        return new Encryption(strength);
    }


}
