package main;


import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AppConfig ac = new AppConfig();
        CryptService es = ac.getEncryptionService();

        Scanner sc = new Scanner(System.in);

        System.out.println("=== 파일 암호화 프로그램 ===");
        System.out.print("사용할 기능의 번호를 입력해주세요. 1. 암호화  2.복호화 \n -입력 : ");
        int function = sc.nextInt();
        sc.nextLine();

        System.out.print("요청하실 파일의 경로를 지정해주세요. \n -입력 : ");
        File file = new File(sc.nextLine());

        File keyFile = null;
        if (function == 2) {
            System.out.print("키파일의 경로를 지정해주세요. \n -입력 : ");
            keyFile = new File(sc.nextLine());
        }


        switch (function) {
            case 1:
                es.encryptFile(file);
                break;
            case 2:
                es.decryptFile(file, keyFile);
                break;
        }

        System.out.println("작업이 완료되었습니다. 폴더를 확인해주세요.");

    }



}
