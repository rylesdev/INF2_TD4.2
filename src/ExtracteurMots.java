import java.io.IOException;

public interface ExtracteurMots {

    String lireMotSuivant() throws IOException;

    int getLigneActuelle();

    void close() throws IOException;
}