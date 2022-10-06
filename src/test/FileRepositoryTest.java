package test;

import main.FileRepository;
import main.Repository;

import java.io.File;

public class FileRepositoryTest {
    public static void main(String[] args) {

        File file = new File("./origin_file/sample");
        Repository repo = new FileRepository();
        System.out.println("file.getPath() = " + file.getPath());

        //파일로드 테스트
        byte[] sampleBytes = repo.load(file.getAbsolutePath());
        System.out.println(new String(sampleBytes));

        //파일세이브 테스트
        String saveStr = "ab[c]de";
        repo.save(saveStr.getBytes(), "./encrypted_file/savedSample");
        byte[] sampleBytes2 = repo.load("./encrypted_file/savedSample");
        System.out.println(new String(sampleBytes2));


    }
}
