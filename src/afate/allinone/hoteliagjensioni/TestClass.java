package afate.allinone.hoteliagjensioni;


import org.junit.Test;

import java.util.Iterator;

public class TestClass {



    @Test
    public void testSmth() throws SkiException {
        Ushqimi mengjesi = new Ushqimi(LlojiUshqimit.Lloji.Mengjesi);
        Ushqimi dreka = new Ushqimi(LlojiUshqimit.Lloji.Dreka);
        Ushqimi darka = new Ushqimi(LlojiUshqimit.Lloji.Darka);
        Skipass skipass = new Skipass(10);
        Aranzhmani a = new Aranzhmani(40,new Hoteli("3 YJET", 2, true), 5);

        a.shtoServisin(mengjesi);
        a.shtoServisin(dreka);
        a.shtoServisin(skipass);



        System.out.println("--------------------------------------------------------------------");

        System.out.println("Cmimi total: " + a.cmimiAranzhmanit());

        Agjencioni agj = new Agjencioni("ILIRIA");

        Aranzhmani a1 = new Aranzhmani(50, new Hoteli("3 YJET", 2, true), 5);
        Aranzhmani a2 = new Aranzhmani(60, new Hoteli("HASAN", 2, true), 5);

        a1.shtoServisin(mengjesi);
        a1.shtoServisin(dreka);
        a1.shtoServisin(skipass);



        agj.shtoAranzhmanin(a);
        agj.shtoAranzhmanin(a1);
        agj.shtoAranzhmanin(a2);

        a2.shtoServisin(mengjesi);
//        a2.shtoServisin(dreka);



        System.out.println("Aranzhmani me i lire me nr.identifikues me te madh: "+ agj.aranzhmaniMeIMire(5));

        System.out.println("-------------------------------------------------------------------------");

        Iterator<Aranzhmani> rr = agj.sortimi("HASAN");
        while (rr.hasNext()) {
            System.out.println(rr.next());
        }
//        System.out.println( agj.sortimi("HASAN"));

//        Iterator<Aranzhmani> testi = agj.sortimi("3 YJET");

    }
}
