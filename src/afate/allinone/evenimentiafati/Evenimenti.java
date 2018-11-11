package afate.allinone.evenimentiafati;

import java.util.ArrayList;
import java.util.List;

public class Evenimenti {

    private int shifra;
    private String tipi;
    private Lokali lokali;
    private int nrMysafireve;
    private List<Artikulli> artikujt;



    public Evenimenti(int shifra, String tipi, Lokali lokali, int nrMysafireve, List<Artikulli> listaArtikujveTeRinje) throws EventException {

        if (shifra <= 0) {
            throw new EventException("Evenimenti: Shifra nuk lejohet negative!");
        }
        if (!(tipi.equalsIgnoreCase("Dasem") ||
                tipi.equalsIgnoreCase("Martese") ||
                tipi.equalsIgnoreCase("Fejese"))) {
            throw new EventException("Evenimenti: Tipi duhet te jete Dasem, Martese apo Fejese");
        }
        if (lokali == null) {
            throw new EventException("Evenimenti: Lokali eshte null !");
        }
        if (nrMysafireve < lokali.getKapaciteti() / 2 || nrMysafireve > lokali.getKapaciteti()) {
            throw new EventException("Evenimenti: Nr i mysafireve nuk eshte ne proporcion!");
        }
        this.shifra = shifra;
        this.tipi = tipi;
        this.lokali = lokali;
        this.nrMysafireve = nrMysafireve;
        artikujt = new ArrayList<>();

        if (listaArtikujveTeRinje == null || listaArtikujveTeRinje.isEmpty()) {
            throw new EventException("Evenimenti: Nuk ka artikuj ne liste");
        } else {
            for (Artikulli a : listaArtikujveTeRinje) {
                if (artikujt.contains(a)) {
                    throw new EventException("Artikulli " + a + " egziston ne liste!");
                } else {
                    artikujt.add(a);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Evenimenti: " + tipi + " : shifra : " + shifra + " : lokali : " + lokali.toString() + " : nr.mysafireve : " + nrMysafireve;
    }

    public double llogaritCmimin() {

        double cmimi = 0;
        double lirimi = 0;

        for (Artikulli a : artikujt) {
            cmimi = cmimi + a.getCmimi();
        }
        cmimi = cmimi * nrMysafireve;

        int countPije = 0;
        for (Artikulli a : artikujt) {
            if (a instanceof Pija) {
                countPije++;
                Pija p = (Pija) a;
                if (p.getLloji().equals(LlojiPijeve.Lloji.Freskuese) && countPije == 1) {
                    lirimi = 5.5;
                } else {
                    lirimi = 7.5;
                }
            }
        }
        return lirimi / 100 * cmimi;
    }


    public String getTipi() {
        return tipi;
    }

    public int getShifra() {
        return shifra;
    }
}
