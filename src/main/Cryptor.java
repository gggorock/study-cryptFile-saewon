package main;

public interface Cryptor {
    int getPrivateKey();
    int getPublicKey();
    Integer generateKey();
    byte[] encrypt(byte[] fileBytes, int privateKey);
    byte[] decrypt(byte[] fileBytes, int publicKey);

}
