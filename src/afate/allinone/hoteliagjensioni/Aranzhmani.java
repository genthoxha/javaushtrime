package afate.allinone.hoteliagjensioni;

import java.util.ArrayList;
import java.util.List;

public class Aranzhmani {

    private int identifikuesi;
    private Hoteli hoteli;
    private int kohezgjatja;
    private List<Servisi> listaESherbimeve;
    private List<LlojiUshqimit.Lloji> llojetEShujtave;

    public int getIdentifikuesi() {
        return identifikuesi;
    }

    public Hoteli getHoteli() {
        return hoteli;
    }

    public Aranzhmani(int identifikuesi, Hoteli hoteli, int kohezgjatja) throws SkiException {
        if (identifikuesi < 0) {
            throw new SkiException("Aranzhmani: Identifikuesi nuk duhet te jete negativ!");
        }
        if (hoteli == null) {
            throw new SkiException("Aranzhmani: Hoteli nuk duhet te jete null");
        }
        if (!(kohezgjatja == 5 || kohezgjatja == 7 || kohezgjatja == 10)) {
            throw new SkiException("Aranzhmani: Kohezgjatja duhet te jete 5, 7 apo 10");
        }
        this.identifikuesi = identifikuesi;
        this.hoteli = hoteli;
        this.kohezgjatja = kohezgjatja;
        listaESherbimeve = new ArrayList<>();
        llojetEShujtave = new ArrayList<>();

    }



    public int getKohezgjatja() {
        return kohezgjatja;
    }

    public List<LlojiUshqimit.Lloji> getLlojetEShujtave() {
        return llojetEShujtave;
    }

    public void shtoShujten(LlojiUshqimit.Lloji shujta) throws SkiException {
        if (shujta == null) {
            throw new SkiException("Aranzhmani: Shujta e pa definuar!");
        }
        if (llojetEShujtave.contains(shujta)) {
            throw new SkiException("Aranzhmani: Nuk mund te jene dy shujta per nje dite!");
        }
        llojetEShujtave.add(shujta);
    }

    public void llojetEshujtaveOut() {
        for (LlojiUshqimit.Lloji a : llojetEShujtave) {
            System.out.println(a);
        }
    }

    public double cmimiAranzhmanit() {
        double cmimiTotal = 0;
        double lirimi = 0;
        List<Ushqimi.Lloji> shujtat = new ArrayList<>();
        for (Servisi servisi : listaESherbimeve) {
            cmimiTotal = cmimiTotal + servisi.cmimi;

            if (servisi instanceof Ushqimi) {
                Ushqimi a = (Ushqimi) servisi;
                shujtat.add(a.getLloji());
            }
        }
        cmimiTotal = cmimiTotal * kohezgjatja;



        if (shujtat.contains(LlojiUshqimit.Lloji.Mengjesi) && (shujtat.contains(LlojiUshqimit.Lloji.Dreka) || shujtat.contains(LlojiUshqimit.Lloji.Darka))) {
            lirimi = 5;
        }
        if (shujtat.contains(LlojiUshqimit.Lloji.Dreka) && shujtat.contains(LlojiUshqimit.Lloji.Darka)) {
            lirimi = 7.5;
        }
        if (shujtat.size() == LlojiUshqimit.Lloji.values().length) {
            lirimi = 10;
        }


        return cmimiTotal * lirimi / 100;
    }

    public void shtoServisin(Servisi servisi) throws SkiException {
        if (servisi == null) {
            throw new SkiException("Aranzhmani: Servisi eshte null");
        }
        if (listaESherbimeve.contains(servisi)) {
            throw new SkiException("Aranzhmani: Servisi egziston");
        }
        listaESherbimeve.add(servisi);
    }

    @Override
    public String toString() {
        return "Aranzhmani: " + identifikuesi + " : " + cmimiAranzhmanit() + " : " + kohezgjatja;
    }
}
