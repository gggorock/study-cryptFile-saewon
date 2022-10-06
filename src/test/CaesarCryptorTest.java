package test;

import main.CaesarCryptor;

public class CaesarCryptorTest {

    public static void main(String[] args) {
        CaesarCryptor cryptor = new CaesarCryptor();
        int privateKey = cryptor.getPrivateKey();
        int publicKey = cryptor.getPublicKey();
        System.out.println("privateKey = " + privateKey);
        System.out.println("publicKey = " + publicKey);

        //given
        String str = "vw[x]yz";

        //when
        byte[] encrypt = cryptor.encrypt(str.getBytes(), privateKey);
        System.out.println(new String(encrypt));

        byte[] decrypt = cryptor.decrypt(encrypt, publicKey);
        System.out.println(new String(decrypt));

        //then
        System.out.println(str.equalsIgnoreCase(new String(decrypt)));



    }
}

