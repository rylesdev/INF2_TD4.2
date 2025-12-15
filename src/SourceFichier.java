import java.io.FileReader;
import java.io.IOException;

public class SourceFichier implements SourceCaracteres {
    private final FileReader reader;

    public SourceFichier(String chemin) throws IOException {
        this.reader = new FileReader(chemin);
    }

    @Override
    public int read() throws IOException {
        return reader.read();
    }

    @Override
    public void close() throws IOException {
        if (reader != null) reader.close();
    }
}