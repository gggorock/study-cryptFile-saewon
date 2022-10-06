package main;

public class AppConfig {

    private CryptionService cryptionService;
    private Repository repository;
    private Cryptor cryptor;

    public AppConfig() {
        encryptionService();
    }

    public CryptionService getEncryptionService() {
        return cryptionService;
    }

    public Repository getRepository() {
        return repository;
    }

    public Cryptor getEncryptor() {
        return cryptor;
    }

    private CryptionService encryptionService() {
        cryptionService = new CryptionService(encryptor(), repository());
        return cryptionService;
    }

    private Repository repository() {
        this.repository = new FileRepository();
        return this.repository;
    }

    private Cryptor encryptor() {
        cryptor = new CaesarCryptor();
        return cryptor;
    }

}
