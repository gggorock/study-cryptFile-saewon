package encryption;

import java.io.File;

public interface Encryptor {
    int getPrivateKey();
    int getPublicKey();
    Integer generateKey();
    String encrypt(String text, int key);

}
