import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class IndexMots implements Index {

    private final SortedMap<String, SortedSet<Integer>> dictionnaire;

    public IndexMots() {
        this.dictionnaire = new TreeMap<>();
    }

    @Override
    public void ajouter(String mot, int numeroLigne) {
        if (mot == null || mot.isEmpty()) return;

        if (!dictionnaire.containsKey(mot)) {
            dictionnaire.put(mot, new TreeSet<>());
        }

        dictionnaire.get(mot).add(numeroLigne);
    }

    @Override
    public SortedMap<String, SortedSet<Integer>> getDonnees() {
        return dictionnaire;
    }
}