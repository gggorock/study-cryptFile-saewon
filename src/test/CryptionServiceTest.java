package test;

import main.CaesarCryptor;
import main.CryptionService;
import main.FileRepository;
import main.Repository;

import java.io.File;

public class CryptionServiceTest {
    public static void main(String[] args) {
        Repository repo = new FileRepository();
        CryptionService cs = new CryptionService(new CaesarCryptor(), repo);

        //encryptFile 테스트
        File sample = new File("./origin_file/sample");
        cs.encryptFile(sample);

        //decryptFile 테스트
        File encryptedSample = new File("./encrypted_file/sample.encrypted");
        File keySample = new File("./encrypted_file/sample.mykey");
        cs.decryptFile(encryptedSample,keySample);

        File decryptedSample = new File("./decrypted_file/sample");
        byte[] originSampleBytes = repo.load(sample.getPath());
        byte[] decryptedSampleBytes = repo.load(sample.getPath());

        System.out.println(new String(originSampleBytes).equalsIgnoreCase(new String(decryptedSampleBytes)));
//        encryptedSample.delete();
//        keySample.delete();
//        decryptedSample.delete();
    }
}
