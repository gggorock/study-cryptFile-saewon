package encryption;


import java.nio.file.Path;

public class EncryptionService {

    private final Encryptor encryptor;
    private final Repository repository;

    public EncryptionService(Encryptor encryptor, Repository fileRepository) {
        this.encryptor = encryptor;
        this.repository = fileRepository;
    }

    public void encryptFile(String path) {
        String plainText = repository.load(path);
        // 패스를 기준으로 저장할 공간과 파일명 수정이 필요.
        String targetPath = getTargetPath(path);
        String encryptedText = encryptor.encrypt(plainText, encryptor.getPrivateKey());
        repository.save(targetPath, encryptedText);
        repository.save(targetPath, Integer.toString(encryptor.getPublicKey()));
    }

    private String getTargetPath(String path) {

    }

}
