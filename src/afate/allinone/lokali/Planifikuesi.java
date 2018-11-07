package afate.allinone.lokali;

import java.util.*;

public class Planifikuesi implements  Tipi {

    private String emri;
    private List<Evenimenti> lista;
    private Tipi.lloji llojiEvenimentit;

    public Planifikuesi(String emri) throws EventException {
        if (Util.isEmpty(emri)) {
            throw new EventException("Planifikuesi: Emri nuk duhet te jete i zbrazet");
        }
        this.emri = emri;
        this.lista = new ArrayList<>();
    }

    public void shtoEvenimentin(Evenimenti evenimenti) throws EventException {
        if (evenimenti == null) {
            throw new EventException("Planifikuesi: Evenimenti eshte i pa inicializuar");
        }
        if (lista.contains(evenimenti)) {
            throw new EventException("Planifikuesi: Evenimenti egziston");
        }
        lista.add(evenimenti);
    }

    public Evenimenti evenimentiVolitshem(Tipi.lloji lloji) {
        Double cmimiMEILire = null;
        Evenimenti evenimentiMeILire = null;
        for (Evenimenti e : lista) {
            if (e.getLloji().equals(lloji)) {
                if (cmimiMEILire == null || cmimiMEILire < e.kalkuloCmimin()) {
                    cmimiMEILire = e.kalkuloCmimin();
                    evenimentiMeILire = e;
                }
            }
        }
        return evenimentiMeILire;
    }

    @Override
    public String toString() {

        StringBuilder s = null;
        s = new StringBuilder();
        for (Evenimenti a : this.lista) {
            s.append("Planifikuesi : " + emri + " : " + llojiEvenimentit + " : Artikujt: [" + a.toString());
        }
        return s + "]";

    }

    public Enumeration<Evenimenti> shfletoEvenimentin(Tipi.lloji llojiEvenimentit, int nr) throws EventException {
        if (llojiEvenimentit == null) {
            throw new EventException("Planifikuesi: lloji evenimentit nuk duhet te jete null");
        }
        if (nr < 0) {
            throw new EventException("Planifikuesi: Nr. nuk duhet te jete negativ");
        }

        class ShfletoEvenimentin implements Enumeration<Evenimenti> {

            private int index = 0;

            @Override
            public boolean hasMoreElements() {
                return index < lista.size();
            }

            @Override
            public Evenimenti nextElement() {
                if (index < lista.size()) {
                    Evenimenti e = lista.get(index++);
                    if (e.getLloji().equals(llojiEvenimentit) && e.getNumri() == nr) {
                        return e;
                    }
                    if (hasMoreElements()) {
                        return nextElement();
                    }
                }
                return null;
            }

        }

        Enumeration<Evenimenti> evenimentetPerTuShfletuar = new ShfletoEvenimentin();
        while (evenimentetPerTuShfletuar.hasMoreElements()) {
            System.out.println(evenimentetPerTuShfletuar.nextElement().toString());
        }
        return new ShfletoEvenimentin();

    }

    public static void main(String[] args) {
        try {
            Planifikuesi planifikuesi = new Planifikuesi("Planifikuesi");
            planifikuesi.shfletoEvenimentin(lloji.Dasem, 40);
            System.out.println(planifikuesi.shfletoEvenimentin(lloji.Dasem, 40));
        } catch (EventException e) {

            e.printStackTrace();
        }
    }
}




























