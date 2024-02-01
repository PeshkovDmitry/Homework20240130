import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.stream.Stream;

public class Backup {

    private File file;

    public Backup(String path) {
        this.file = new File(path);
    }

    public void make() {
        File backupDir = new File("./backup");
        backupDir.mkdir();
        Stream<File> filestream = Arrays.stream(file.listFiles());
        filestream
                .filter(f -> f.isFile())
                .forEach(s ->
                        {
                            try {
                                Files.copy(
                                        s.toPath(),
                                        (new File(backupDir.getPath() + "/" + s.getName())).toPath());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
        );
    }

}
