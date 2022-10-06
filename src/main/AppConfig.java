package main;

public class AppConfig {

    private CryptService cryptionService;

    AppConfig() {
        encryptionService();
    }

    CryptService getEncryptionService() {
        return cryptionService;
    }

    private CryptService encryptionService() {
        cryptionService = new CryptService(encryptor(), repository());
        return cryptionService;
    }

    private Repository repository() {
        return new FileRepository();
    }

    private Cryptor encryptor() {
        return new CaesarCryptor();
    }

}
