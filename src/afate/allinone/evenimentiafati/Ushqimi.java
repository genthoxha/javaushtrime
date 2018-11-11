package afate.allinone.evenimentiafati;

import afate.allinone.lokali.EventException;

public class Ushqimi extends Artikulli {

    private String emri;

    public Ushqimi(double cmimi, String emri) throws EventException {
        super(cmimi);
        if (emri == null || emri.trim().isEmpty()) {
            throw new EventException("Ushqimi: Emri i ushqimit NULL!");
        }
        this.emri = emri;
    }

    @Override
    public String toString() {
        return super.toString() + " dhe emrin: " + emri;
    }
}
