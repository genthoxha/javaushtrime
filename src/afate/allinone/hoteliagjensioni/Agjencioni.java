package afate.allinone.hoteliagjensioni;

import java.util.ArrayList;
import java.util.List;

public class Agjencioni {
    private String emri;
    private List<Aranzhmani> listaAranzhmaneve;

    public Agjencioni(String emri) throws SkiException {
        if (emri == null || emri.trim().isEmpty()) {
            throw new SkiException("Agjencioni: Emri nuk duhet te jete null");
        }
        this.emri = emri;
        listaAranzhmaneve = new ArrayList<>();
    }

    public void shtoAranzhmanin(Aranzhmani aranzhmani) throws SkiException {
        if (aranzhmani == null) {
            throw new SkiException("Agjencioni: Aranzhmani NULL");
        }
        if (listaAranzhmaneve.contains(aranzhmani)) {
            throw new SkiException("Agjencioni: Aranzhmani egziston");
        }
        listaAranzhmaneve.add(aranzhmani);
    }
}
