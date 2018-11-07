package afate.allinone.lokali;

import java.util.ArrayList;
import java.util.List;

public class Planifikuesi implements  Tipi{

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

    public void shtoEvenimentin(Evenimenti evenimenti)throws EventException {
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

}
