package encryption;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public interface Repository {
    String load(String path);

    boolean save(String path, String text) ;
}
