package main;

public interface Repository {
    byte[] load(String path);

    boolean save(byte[] fileBytes, String targetPath) ;
}
