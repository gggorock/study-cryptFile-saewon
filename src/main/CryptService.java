package main;


import java.io.File;

public class CryptService {

    private final Cryptor cryptor;
    private final Repository repository;

    public CryptService(Cryptor cryptor, Repository fileRepository) {
        this.cryptor = cryptor;
        this.repository = fileRepository;
    }

    public void encryptFile(File originFile) {
        byte[] originFileBytes = repository.load(originFile.getPath());

        String encryptedFilePath = "./encrypted_file/"+originFile.getName()+".encrypted"; // 서비스 클래스에서 경로관련한 역할을 누군가에게 부여해야할것같음.
        String keyPath = "./encrypted_file/"+originFile.getName()+".mykey";

        byte[] encryptedFileBytes = cryptor.encrypt(originFileBytes, cryptor.getPrivateKey());
        repository.save(encryptedFileBytes, encryptedFilePath);
        repository.save(Integer.toString(cryptor.getPublicKey()).getBytes(),keyPath);
    }


    public void decryptFile(File encryptedFile, File keyFile) {
        byte[] originFileBytes = repository.load(encryptedFile.getPath());
        byte[] keyFileBytes = repository.load(keyFile.getPath());
        int publickey = Integer.parseInt(new String(keyFileBytes)); // 과연 이렇게 키를 가져오는 방법이 최적인가
        String decryptedFilePath = "./decrypted_file/" + encryptedFile.getName().substring(0,encryptedFile.getName().length()-10);

        byte[] encryptedFileBytes = cryptor.decrypt(originFileBytes, publickey);
        repository.save(encryptedFileBytes, decryptedFilePath);
    }

}
