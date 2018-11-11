package afate.allinone.evenimentiafati;

import afate.allinone.lokali.EventException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Enumeration;

public class testinjo {

    @Test
    public void methodToTest() throws EventException, afate.allinone.evenimentiafati.EventException {

        ArrayList<Artikulli> artikujt = new ArrayList<>();

        artikujt.add(new Pija(LlojiPijeve.Lloji.Freskuese));
        artikujt.add(new Pija(LlojiPijeve.Lloji.Birre));

        artikujt.add(new Dekorimi(3));
        artikujt.add(new Ushqimi(3, "Torte"));

        ArrayList<Artikulli> artikujtElire = new ArrayList<>();
        artikujtElire.add(new Pija(LlojiPijeve.Lloji.Vere));
        artikujtElire.add(new Ushqimi(1, "Paragjella"));


        ArrayList<Artikulli> shtrejte = new ArrayList<>();
        shtrejte.addAll(artikujt);
        shtrejte.addAll(artikujtElire);





        Evenimenti a = new Evenimenti(666, "Dasem", new Lokali("Te Gafurri", 100), 50, artikujt);
        Evenimenti b = new Evenimenti(666, "Dasem", new Lokali("XIXELLONJA", 100), 50, artikujtElire);
        Evenimenti c = new Evenimenti(555, "Dasem", new Lokali("27 YJET", 100), 50, shtrejte);

        Planifikuesi p = new Planifikuesi("Planifikuesi");
        p.shtoEvenimentin(a);
        p.shtoEvenimentin(b);
        p.shtoEvenimentin(c);

        Enumeration<Evenimenti> enumEvent = p.shfletoEvenimentet("Martese");

        while (enumEvent.hasMoreElements()) {
            System.out.println(enumEvent.nextElement());

        }
        System.out.println("---------------------------------------------------------------------------");
        System.out.println(p.evenimentiMeIVolitshem("Dasem"));
        System.out.println("---------------------------------------------------------------------------");
        ArrayList<Evenimenti> teGjithaEvenimentet = new ArrayList<>();
        teGjithaEvenimentet.add(a);
        teGjithaEvenimentet.add(b);
        teGjithaEvenimentet.add(c);
        for (Evenimenti e : teGjithaEvenimentet) {
            System.out.println(e.llogaritCmimin());
        }






    }

}
