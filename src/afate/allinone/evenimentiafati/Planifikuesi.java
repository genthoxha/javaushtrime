package afate.allinone.evenimentiafati;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class Planifikuesi {
    private String emri;
    private List<Evenimenti> lista;

    public Planifikuesi(String emri) throws EventException {
        if (emri == null || emri.trim().isEmpty()) {
            throw new EventException("Planifikuesi: Emri eshte null");
        }
        this.emri = emri;
        lista = new ArrayList<>();
    }

    public String getEmri() {
        return emri;
    }

    public List<Evenimenti> getLista() {
        return lista;
    }

    public void shtoEvenimentin(Evenimenti evenimenti) throws EventException {
        if (evenimenti == null) {
            throw new EventException("Planifikuesi: Evenimenti null");
        }
        if (lista.contains(evenimenti)) {
            throw new EventException("Planifikuesi: Evenimenti egziston");
        }
        lista.add(evenimenti);
    }

    public Evenimenti evenimentiMeIVolitshem(String tipi) {
        Evenimenti evenimenti = null;
        for (Evenimenti e : lista) {
            if (evenimenti == null || evenimenti.getTipi().equals(tipi)) {
                if (evenimenti == null || e.llogaritCmimin()  < evenimenti.llogaritCmimin()) {
                    if (evenimenti == null || evenimenti.getShifra() > e.getShifra()) {
                        evenimenti = e;
                    }
                }
            }
        }
        return evenimenti;
    }

    public Enumeration<Evenimenti> shfletoEvenimentet(String tipi) {

        class locale implements Enumeration<Evenimenti> {

            int index = 0;

            @Override
            public boolean hasMoreElements() {
                return index < lista.size();
            }

            @Override
            public Evenimenti nextElement() {
                if (hasMoreElements()) {
                    Evenimenti e = lista.get(index++);
                    if (e.getTipi().equalsIgnoreCase(tipi)) {
                        return e;
                    }
                }
                if (hasMoreElements()) {
                    return nextElement();
                }
                return null;
            }
        }
        return new locale();

    }
}
