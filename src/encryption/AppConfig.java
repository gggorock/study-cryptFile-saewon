package encryption;

public class AppConfig {

    private EncryptionService encryptionService;
    private Repository repository;
    private Encryptor encryptor;

    public AppConfig() {
        encryptionService();
    }

    public EncryptionService getEncryptionService() {
        return encryptionService;
    }

    public Repository getRepository() {
        return repository;
    }

    public Encryptor getEncryptor() {
        return encryptor;
    }

    private EncryptionService encryptionService() {
        encryptionService = new EncryptionService(encryptor(), repository());
        return encryptionService;
    }

    private Repository repository() {
        this.repository = new FileRepository();
        return this.repository;
    }

    private Encryptor encryptor() {
        encryptor = new CaesarEncryptor();
        return encryptor;
    }

}
