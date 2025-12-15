import java.io.IOException;
import java.util.Map;
import java.util.SortedSet;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Test Chaine ===");
        String texte = "Un tout petit chien, joli \n ronge un joli petit os;\n \nTout ce qui est petit est joli. ";
        executerTest(new SourceChaine(texte));

        System.out.println("\n=== Test Fichier ===");
        try {
            executerTest(new SourceFichier("src/test.txt"));
        } catch (IOException e) {
            System.err.println("Erreur fichier : " + e.getMessage());
        }
    }

    private static void executerTest(SourceCaracteres source) {
        try {
            ExtracteurMots extracteur = new Extracteur(source);
            Index monIndex = new IndexMots();

            String mot;
            while ((mot = extracteur.lireMotSuivant()) != null) {
                monIndex.ajouter(mot.toLowerCase(), extracteur.getLigneActuelle());
            }

            afficherIndex(monIndex);

            extracteur.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void afficherIndex(Index index) {
        Map<String, SortedSet<Integer>> donnees = index.getDonnees();

        for (String mot : donnees.keySet()) {
            System.out.print(mot + ":");
            for (Integer ligne : donnees.get(mot)) {
                System.out.print(" " + ligne);
            }
            System.out.println();
        }
    }
}