package afate.allinone.detyrateshtepise.Artikulli;


import java.io.*;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class Dyqani {
    private String emri;
    private ReentrantLock radha;
    private List<Artikulli> artikujt;
    private Hashtable<Klienti,ArrayList<Artikulli>> shitjet;

    public Dyqani(String emri) throws BlerjaException{
        if(emri == null || emri.trim().isEmpty()){
            throw new BlerjaException("Emri i dyqanit nuk duhet te jete i zbrazet");
        }
        this.emri = emri;
        radha = new ReentrantLock();
        artikujt = new Vector<>();
        shitjet = new Hashtable<>();
    }



    public String getEmri() {
        return emri;
    }

    public ReentrantLock getRadha() {
        return radha;
    }

    public void shtoArtikullin(Artikulli a) throws BlerjaException{
        if(a == null){
            throw new BlerjaException("Artikulli duhet inicializuar");
        }
        if(artikujt.contains(a)){
            throw new BlerjaException("Artikulli ekziston");
        }
        artikujt.add(a);
    }

    public boolean kaArtikuj(){
        return !artikujt.isEmpty();
    }

    public Artikulli shiteArtikullin(Klienti k){
        if(kaArtikuj()){
            Artikulli a = artikujt.remove(0);
            regjistroShitjen(k, a);
            return a;
        }
        return null;
    }

    public void regjistroShitjen(Klienti k, Artikulli a) {
        if(shitjet.containsKey(k)){
            ArrayList <Artikulli> temp = shitjet.get(k);
            if(a != null){
                temp.add(a);
                shitjet.put(k, temp);
            }
            return;
        }
        ArrayList<Artikulli> temp = new ArrayList<>();
        temp.add(a);
        shitjet.put(k, temp);
    }

    public void faturo(){
        Enumeration<Klienti> en = shitjet.keys();
        while(en.hasMoreElements()){
            Klienti k = en.nextElement();
            try(PrintWriter pw = new PrintWriter(new FileWriter("F://gent//"+k.getEmri()+".txt"))){
                double cmimi = 0;
                final String viza = "-------------------------------------";
                pw.println("Klienti: "+k);
                pw.println(viza);
                pw.println("Numri i Artikujve: "+shitjet.get(k).size());
                pw.println(viza);
                Iterator<Artikulli> it = shitjet.get(k).iterator();
                while(it.hasNext()){
                    Artikulli a = it.next();
                    cmimi += a.getCmimi();
                    pw.println(a);
                }
                pw.println(viza);
                pw.println("Totali: "+cmimi);
                pw.println(viza);
                pw.flush();
            }catch(IOException ioe){
            }
        }
    }


}
