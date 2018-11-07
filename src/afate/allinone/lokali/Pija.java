package afate.allinone.lokali;

public class Pija extends Artikulli implements LlojiPijeve {

    private LlojiPijeve.llojet lloji;

    public Pija(LlojiPijeve.llojet lloji) throws EventException {
        super(1);
        if (lloji == null) {
            throw new EventException("Pija: Lloji i pijes eshte null !");
        }
        this.lloji = lloji;
    }

    public llojet getLlojiPijeve() {
        return lloji;
    }

    public void setLlojiPijeve(llojet llojiPijeve) {
        this.lloji = llojiPijeve;
    }

    public String toString() {
        return super.toString() + " me llojin: " + lloji;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Pija) {
            Pija p = (Pija) obj;
            return lloji.equals(p.lloji);
        }
        return false;
    }
}
