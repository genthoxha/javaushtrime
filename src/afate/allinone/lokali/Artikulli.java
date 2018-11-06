package afate.allinone.lokali;

public abstract class Artikulli {
    private int cmimi;

    public Artikulli(int cmimi) throws EventException {
        if (cmimi < 0) {
            throw new EventException("Artikulli: Cmimi duhet te jete pozitiv");
        }
        this.cmimi = cmimi;

    }

    public int getCmimi() {
        return cmimi;
    }

    public void setCmimi(int cmimi) {
        this.cmimi = cmimi;
    }

}
