package main;

import java.io.*;

public class FileRepository implements Repository {

    @Override
    public byte[] load(String fileName)  {
        FileInputStream fis = null;
        byte[] fileBytes = null;

        try {
            fis = new FileInputStream(fileName);
            fileBytes = fis.readAllBytes();

        } catch (IOException e) {
            e.toString();
        } finally{
            try {
                fis.close();
            } catch (IOException e) {
                e.toString();
            }
        }

        return fileBytes;

    }

    @Override
    public boolean save(byte[] fileBytes, String targetPath)  {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(targetPath);
            fos.write(fileBytes);
            fos.flush();
        } catch (IOException e) {
            e.toString();
            return false;
        } finally{
            try {
                fos.close();
            } catch (IOException e) {
                e.toString();
            }
        }
        return true;
    }



}
