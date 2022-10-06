package main;

import java.util.Random;

public class CaesarCryptor implements Cryptor {

    private int publicKey;
    private int privateKey;


    public CaesarCryptor() {
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
    public byte[] encrypt(byte[] fileBytes, int privateKey) {
        return caesarLogic(fileBytes, privateKey);
    }

    @Override
    public byte[] decrypt(byte[] fileBytes, int publicKey) {
        return caesarLogic(fileBytes, publicKey);
    }

    private byte[] caesarLogic(byte[] fileBytes, int key) {
        String originalText = new String(fileBytes);
        char[] chars = originalText.toCharArray();
        moveChar(chars, key);
        return new String(chars).getBytes();
    }


    private void moveChar(char[] chars,int key) {
        for (int index = 0; index < chars.length; index++) {
            if (isLowerCase(chars[index])) {
                int temp = chars[index] - 'a' + key;
                if (temp < 0) temp += 26; // 키를 더한 값이 음수면 나머지연산에 착오가 생김
                chars[index] = (char) ((temp % 26) + 'a');
            } else if (isLargerCase(chars[index])) {
                int temp = chars[index] - 'A' + key;
                if (temp < 0) temp += 26;
                chars[index] = (char) ((temp % 26) + 'A');
            }

        }
    }

    private boolean isLargerCase(char c)  {
        return 'A' <= c && c <= 'Z';
    }


    private boolean isLowerCase(char c) {
        return 'a' <= c && c <= 'z';
    }


}


