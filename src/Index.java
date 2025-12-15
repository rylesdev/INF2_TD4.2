import java.util.SortedMap;
import java.util.SortedSet;

public interface Index {

    void ajouter(String mot, int numeroLigne);

    SortedMap<String, SortedSet<Integer>> getDonnees();
}