package afate.allinone.detyrateshtepise.Artikulli;


import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class Dyqani {

    private String emri;
    private ReentrantLock radha;
    private Vector<Artikulli> listaArtikujve;
    private Hashtable<Klienti, ArrayList<Artikulli>> shitjet;

    public Dyqani(String emri) throws ArtikulliException {
        if (emri == null || emri.trim().isEmpty()) {
            throw new ArtikulliException("Emri nuk duhet te jete i zbrazet!");
        }
        this.emri = emri;
        radha = new ReentrantLock();
        listaArtikujve = new Vector<>();
        shitjet = new Hashtable<>();
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public Vector<Artikulli> getListaArtikujve() {
        return listaArtikujve;
    }

    public void setListaArtikujve(Vector<Artikulli> listaArtikujve) {
        this.listaArtikujve = listaArtikujve;
    }

    public Hashtable<Klienti, ArrayList<Artikulli>> getShitjet() {
        return shitjet;
    }

    public void setShitjet(Hashtable<Klienti, ArrayList<Artikulli>> shitjet) {
        this.shitjet = shitjet;
    }

    public ReentrantLock getRadha() {
        return radha;
    }

    public void shtoArtikullin(Artikulli a) throws ArtikulliException {
        if (a == null) {
            throw new ArtikulliException("Dyqani shtoArtikullin: Artikulli eshte null !");
        }
        if (listaArtikujve.contains(a)) {
            throw new ArtikulliException("Dyqani shtoArtikullin: Artikulli egziston.");
        }
        listaArtikujve.add(a);
    }

    public boolean kaArtikuj() {
        return !listaArtikujve.isEmpty();
    }

    public Artikulli shiteArtikullin(Klienti klienti) {
        if (kaArtikuj()) {
            Artikulli a = listaArtikujve.remove(0);
            regjistroShitjen(klienti, a);
            return a;
        }
        return null;
    }


}

