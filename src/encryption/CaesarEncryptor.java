package encryption;

import java.util.Random;

public class CaesarEncryptor implements Encryptor {

    private int publicKey;
    private int privateKey;


    public CaesarEncryptor() {
        generateKey();
    }

    @Override
    public int getPrivateKey() {
        return privateKey;
    }

    @Override
    public int getPublicKey() {
        return publicKey;
    }

    @Override
    public Integer generateKey() {
        Random random = new Random();
        privateKey = random.nextInt(26);
        publicKey = -privateKey;
        return publicKey;
    }


    @Override
    public String encrypt(String text, int privateKey) {
        char[] chars = text.toLowerCase().toCharArray();
        moveChar(privateKey, chars);
        return new String(chars).toUpperCase();
    }

    private void moveChar(int privateKey, char[] chars) {
        for (int index = 0; index < chars.length; index++) {
            if (isTarget(chars[index])) {
                chars[index] = (char) (((chars[index] - 'a' + privateKey) % 26) + 'a');
            }

        }
    }

    private boolean isTarget(char c) {
        return 'a' <= c && c <= 'z';
    }



}


