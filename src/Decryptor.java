public class Decryptor {
    public String decrypt(String plainText, int key) {
        plainText.toLowerCase();

        byte[] bytes = plainText.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] -= key;
        }

        return new String(bytes);
    }
}
