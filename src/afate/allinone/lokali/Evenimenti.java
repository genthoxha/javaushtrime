package afate.allinone.lokali;

import java.util.ArrayList;

public class Evenimenti implements LlojiPijeve {
    private int shifra;
    private Lokali lokali;
    private int numri;
    private ArrayList<Artikulli> lista;
    private Tipi.lloji lloji;

    public Evenimenti(int shifra, Lokali l, int numri, Tipi.lloji lloji) throws EventException {
        if (shifra <= 0) {
            throw new EventException("Evenimenti: Shifra negative");
        }
        if (l == null) {
            throw new EventException("Evenimenti: Lokali eshte null");
        }
        if (numri < l.getKapaciteti() / 2 && numri > l.getKapaciteti()) {
            throw new EventException("Kapaciteti ma i vogel se sa duhet ose ma i madh se sa mund te mbaje lokali!");
        }
        if (lloji == null) {
            throw new EventException("Evenimenti: Tipi i evenimentit nuk duhet te jete NULL!");
        }
        this.shifra = shifra;
        this.lokali = l;
        this.numri = numri;
        this.lloji = lloji;
        lista = new ArrayList<>();
    }


    public double kalkuloCmimin() {
        double cmimi = 0;
        double lirimi = 0;

        for (Artikulli a : lista) {
            cmimi = cmimi + a.getCmimi();
        }

        if (this.lloji.equals(LlojiPijeve.llojet.Freskuese)) {
            lirimi = 5.5;
        } else if (this.lloji.equals(LlojiPijeve.llojet.Birre) || this.lloji.equals(LlojiPijeve.llojet.Vere)) {
            lirimi = 7.5;
        }
        return lirimi / 100 * cmimi;
    }

    public int getShifra() {
        return shifra;
    }

    public void setShifra(int shifra) {
        this.shifra = shifra;
    }

    public Lokali getLokali() {
        return lokali;
    }

    public void setLokali(Lokali lokali) {
        this.lokali = lokali;
    }

    public int getNumri() {
        return numri;
    }

    public void setNumri(int numri) {
        this.numri = numri;
    }

    public ArrayList<Artikulli> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Artikulli> lista) {
        this.lista = lista;
    }

    public Tipi.lloji getLloji() {
        return lloji;
    }

    public void setLloji(Tipi.lloji lloji) {
        this.lloji = lloji;
    }

    public void artikujt() {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }

    public String toString() {
        StringBuilder s = null;
        s = new StringBuilder();
        for (Artikulli a : this.lista) {
            s.append("Evenimenti: " + numri + " : " + lokali + " : Artikujt: [" + a.toString());
        }
        return s + "]";
    }
}
