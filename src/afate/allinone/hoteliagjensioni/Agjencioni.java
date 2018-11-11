package afate.allinone.hoteliagjensioni;

import java.lang.reflect.Array;
import java.util.*;

public class Agjencioni {
    private String emri;

    public String getEmri() {
        return emri;
    }

    private ArrayList<Aranzhmani> listaAranzhmaneve;

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

    public Aranzhmani aranzhmaniMeIMire(int ditet) throws SkiException {
        if (!(ditet == 5 || ditet == 7 || ditet == 10)) {
            throw new SkiException("Aranzhmani aranzhmaniMeIMire(): Shtyp 5 , 7 ose 10!");
        }
        Aranzhmani MIN = null;

        for (int i = 0; i < listaAranzhmaneve.size(); i++) {
            if (MIN == null || MIN.cmimiAranzhmanit() < listaAranzhmaneve.get(i).cmimiAranzhmanit()) {
                MIN = listaAranzhmaneve.get(i);
            }
        }

        for (int i = 0; i < listaAranzhmaneve.size(); i++) {
            if ((MIN == null || MIN.cmimiAranzhmanit() < listaAranzhmaneve.get(i).cmimiAranzhmanit())
                    && MIN.getIdentifikuesi() < listaAranzhmaneve.get(i).getIdentifikuesi()) {
                MIN = listaAranzhmaneve.get(i);
            }
        }
        if (MIN != null) {
            return MIN;
        } else {
            return null;
        }
    }

    public Iterator<Aranzhmani> sortimi(String emri) throws SkiException {
        if (emri == null || emri.trim().isEmpty()) {
            throw new SkiException("Emri nuk dhet te jete null");
        }
        ArrayList<Aranzhmani> equalsEmri = new ArrayList<>();
        class lokale implements Iterator<Aranzhmani> {

            private int index = 0;
            public boolean hasNext() {
                return index < listaAranzhmaneve.size();
            }
            public Aranzhmani next() {
                if (index < listaAranzhmaneve.size()) {
                    Aranzhmani a = listaAranzhmaneve.get(index++);
                    if (a.getHoteli().getEmri().equals(emri)) {
                        equalsEmri.add(a);
                    }
                    if (hasNext()){
                        next();
                    }
                    return a;
                }
                return null;
            }
        }


//        Collections.sort(equalsEmri, new Comparator<Aranzhmani>() {
//            @Override
//            public int compare(Aranzhmani o1, Aranzhmani o2) {
//                return o2.getIdentifikuesi() - o1.getIdentifikuesi();
//            }
//        });



        return new lokale();
    }
}

