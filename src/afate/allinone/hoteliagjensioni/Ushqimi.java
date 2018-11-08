package afate.allinone.hoteliagjensioni;

public class Ushqimi extends Servisi implements LlojiUshqimit {

    private LlojiUshqimit.Lloji lloji;

    public Ushqimi(LlojiUshqimit.Lloji ushqimiMeCmim) throws SkiException {
        super(ushqimiMeCmim.getCmimi());
        this.lloji = ushqimiMeCmim;
    }

    public Lloji getLloji() {
        return lloji;
    }

    public void setLloji(Lloji lloji) {
        this.lloji = lloji;
    }

    @Override
    public String toString() {
        return lloji.toString();
    }
}
