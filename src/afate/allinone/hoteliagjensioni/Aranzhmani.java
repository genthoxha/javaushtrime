package afate.allinone.hoteliagjensioni;

public class Aranzhmani extends Servisi{

    private String shifra;
    private Hoteli hoteli;
    private int kohezgjatja;


    public Aranzhmani(int cmimi,String shifra, Hoteli hoteli, int kohezgjatja) throws SkiException {
        super(cmimi);
        if (Util.isEmpty(shifra)) {
            throw new SkiException("Aranzhmani: Shifra nuk duhet te jete null");
        }
        if (hoteli == null) {
            throw new SkiException("Aranzhmani: Hoteli eshte i pa inicializuar");
        }
        if (kohezgjatja != 5 && kohezgjatja != 7 && kohezgjatja != 10) {
            throw new SkiException("Aranzhmani: Kohezgjatja duhet te jete 5 , 7 apo 10 dite!");
        }
    }

    @Override
    public void fjetja() {

    }

    @Override
    public void Ushqimi(llojiUshqimit.Vakti vakti) {

    }


    @Override
    public void Skipass() {

    }
}
