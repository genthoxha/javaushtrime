package afate.allinone.evenimentiafati;

import afate.allinone.lokali.EventException;

public class Pija extends Artikulli implements LlojiPijeve {

    private Lloji lloji;

    public Pija(Lloji lloji) throws EventException {
        super(1);
        if (lloji == null) {
            throw new EventException("Pija: Lloji eshte NULL");
        }
        this.lloji = lloji;
    }

    public Lloji getLloji() {
        return lloji;
    }



    @Override
    public String toString() {
        return super.toString()+ " lloji: "+lloji;
    }
}
