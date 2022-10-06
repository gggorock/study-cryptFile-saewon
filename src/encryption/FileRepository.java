package encryption;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileRepository implements Repository {

    public String load(String path) {
        String text = null;
        try {
            text = Files.readString(Path.of(path));

        } catch (IOException e) {
            e.toString();
        }
        return text;
    }

    public boolean save(String path, String text)  {
        FileWriter fw = null;
        try {
            fw = new FileWriter(path);
            fw.write(text);
        } catch (IOException e) {
            e.toString();
            return false;
        } finally{
            try {
                fw.close();
            } catch (IOException e) {
                e.toString();
            }
        }
        return true;
    }



}
