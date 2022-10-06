package encryption;



public class Encryption {
    public static void main(String[] args) {
        String path = args[0];

        AppConfig ac = new AppConfig();
        EncryptionService es = ac.getEncryptionService();

        es.encryptFile(path);

    }



}
