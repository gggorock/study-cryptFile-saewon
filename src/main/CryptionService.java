package main;


import java.io.File;

public class CryptionService {

    private final Cryptor cryptor;
    private final Repository repository;

    public CryptionService(Cryptor cryptor, Repository fileRepository) {
        this.cryptor = cryptor;
        this.repository = fileRepository;
    }

    public void encryptFile(File originFile) {
        byte[] originalFileBytes = repository.load(originFile.getPath());

        String encryptedFilePath = "./encrypted_file/"+originFile.getName()+".encrypted";
        String keyPath = "./encrypted_file/"+originFile.getName()+".mykey";

        byte[] encryptedFileBytes = cryptor.encrypt(originalFileBytes, cryptor.getPrivateKey());
        repository.save(encryptedFileBytes, encryptedFilePath);
        repository.save(Integer.toString(cryptor.getPublicKey()).getBytes(),keyPath);
    }


    public void decryptFile(File encryptedFile, File keyFile) {
        byte[] originalFileBytes = repository.load(encryptedFile.getPath());
        byte[] keyFileBytes = repository.load(keyFile.getPath());
        int publickey = Integer.parseInt(new String(keyFileBytes));

        String decryptedFilePath = "./decrypted_file/" + encryptedFile.getName().substring(0,encryptedFile.getName().length()-10);

        byte[] encryptedFileBytes = cryptor.decrypt(originalFileBytes, publickey);
        repository.save(encryptedFileBytes, decryptedFilePath);
    }

}
