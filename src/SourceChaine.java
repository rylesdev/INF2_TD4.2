import java.io.IOException;

public class SourceChaine implements SourceCaracteres {
    private final String contenu;
    private int position;

    public SourceChaine(String texte) {
        this.contenu = texte;
        this.position = 0;
    }

    @Override
    public int read() throws IOException {
        if (position >= contenu.length()) return -1;
        return contenu.charAt(position++);
    }

    @Override
    public void close() throws IOException {
    }
}