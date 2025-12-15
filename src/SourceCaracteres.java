import java.io.IOException;

public interface SourceCaracteres {
    int read() throws IOException;
    void close() throws IOException;
}