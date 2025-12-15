import java.io.IOException;

public class Extracteur implements ExtracteurMots {

    private final SourceCaracteres source;
    private int ligneActuelle;
    private int ligneDernierMot;
    private int tamponCaractere;

    public Extracteur(SourceCaracteres source) throws IOException {
        this.source = source;
        this.ligneActuelle = 1;
        this.ligneDernierMot = 1;
        this.tamponCaractere = source.read();
    }

    @Override
    public String lireMotSuivant() throws IOException {
        while (tamponCaractere != -1 && !Character.isLetterOrDigit(tamponCaractere)) {
            if (tamponCaractere == '\n') {
                ligneActuelle++;
            } else if (tamponCaractere == '\r') {
                tamponCaractere = source.read();
                continue;
            }
            tamponCaractere = source.read();
        }

        if (tamponCaractere == -1) {
            return null;
        }

        this.ligneDernierMot = ligneActuelle;

        StringBuilder sb = new StringBuilder();
        while (tamponCaractere != -1 && Character.isLetterOrDigit(tamponCaractere)) {
            sb.append((char) tamponCaractere);
            tamponCaractere = source.read();
        }

        return sb.toString();
    }

    @Override
    public int getLigneActuelle() {
        return ligneDernierMot;
    }

    @Override
    public void close() throws IOException {
        source.close();
    }
}