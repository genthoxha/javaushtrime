package afate.allinone.detyrateshtepise.Artikulli;

import java.util.ArrayList;

public class Klienti {

    private String emri;
    private int mosha;
    private char gjinia;
    private ArrayList<Artikulli> shporta;

    public Klienti(String emri,int mosha,char gjinia) {
        this.emri = emri;
        this.mosha = mosha;
        this.gjinia = gjinia;
        shporta = new ArrayList<>();
    }

    public char getGjinia() {
        return gjinia;
    }

    public int getMosha() {
        return mosha;
    }

    public void setMosha(int mosha) {
        this.mosha = mosha;
    }

    public String getEmri() {
        return emri;
    }

    public ArrayList<Artikulli> getShporta() {
        return shporta;
    }

    public void setShporta(ArrayList<Artikulli> shporta) {
        this.shporta = shporta;
    }



    public boolean merreRadhen(Dyqani dyqani) {
        if (dyqani.getRadha().tryLock()) {
            return true;
        }
        return false;
    }

    public void blej(Dyqani dyqani) {
        if (dyqani.kaArtikuj()) {
            if (merreRadhen(dyqani)) {
                Artikulli a = dyqani.shiteArtikullin(this);
                if (a != null) {
                    shporta.add(a);
                    System.out.println(emri + " bleu me sukses artikullin " + a + " ne dyqanin " + dyqani.getEmri());
                    dyqani.getRadha().unlock();
                }
            } else {
                System.out.println(emri + " nuk e morri radhen ne dyqanin " + dyqani.getEmri());
            }
        }
    }

    public String toString() {
        return emri + " - " + (gjinia == 'M' ? " mashkull " : " femer ") + mosha + " vjec";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Klienti) {
            Klienti k = (Klienti) obj;
            return ((Klienti)obj).getEmri().equals(emri)
                    && ((Klienti)obj).getMosha() == mosha
                    && ((Klienti)obj).getGjinia() == gjinia;
        }
        return false;
    }
}
