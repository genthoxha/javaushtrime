package afate.allinone.hoteliagjensioni;

import org.junit.Test;

public class TestClass {


    @Test
    public void testSmth() throws SkiException {
        Ushqimi mengjesi = new Ushqimi(LlojiUshqimit.Lloji.Mengjesi);
        Ushqimi dreka = new Ushqimi(LlojiUshqimit.Lloji.Dreka);
        Ushqimi darka = new Ushqimi(LlojiUshqimit.Lloji.Darka);
        Skipass skipass = new Skipass(10);
        Aranzhmani a = new Aranzhmani(113113,new Hoteli("3 YJET", 2, true), 5);

        a.shtoServisin(darka);
        a.shtoServisin(dreka);
        a.shtoServisin(mengjesi);



        System.out.println("--------------------------------------------------------------------");

        System.out.println("Cmimi total: " + a.cmimiAranzhmanit());


    }
}
