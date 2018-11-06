package afate.allinone.detyrateshtepise.Artikulli;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class BlackFriday {
    private Dyqani dyqani;
    private List<Klienti> klientet;

    public BlackFriday(Dyqani dyqani) throws BlerjaException{
        if(dyqani == null){
            throw new BlerjaException("Dyqani duhet inicializuar");
        }
        this.dyqani = dyqani;
        klientet = new ArrayList<>();
    }

    private class Blerja implements Runnable{
        private Dyqani d;
        private Klienti k;

        public Blerja(Dyqani d, Klienti k) throws BlerjaException{
            if(d == null){
                throw new BlerjaException("Dyqani duhet inicializuar");
            }
            this.d = d;
            if(k == null){
                throw new BlerjaException("Dyqani duhet inicializuar");
            }
            this.k = k;
        }

        @Override
        public void run(){
            while(d.kaArtikuj()){
                try{
                    Thread.sleep(new Random().nextInt(250));
                }catch(InterruptedException ie){
                    ie.printStackTrace();
                }
                k.blej(d);
            }
            d.faturo();
        }


    }



    public void lexoArtikuj() throws BlerjaException{
        try(BufferedReader br = new BufferedReader(new FileReader("F:/gent/artikujt.txt"))){
            String rreshti;
            Artikulli a = null;
            while((rreshti = br.readLine()) != null){
                String [] parametrat = rreshti.split(":");
                if(parametrat.length == 5){
                    String lloji = parametrat[0];
                    int barkodi = Integer.parseInt(parametrat[1]);
                    String emertimi = parametrat[2];
                    double cmimi = Double.parseDouble(parametrat[3]);
                    switch(lloji){
                        case "TV":
                            a = new TV(barkodi, emertimi, cmimi, Boolean.parseBoolean(parametrat[4]));
                            break;
                        case "DVDPlayer":
                            a = new DVDPlayer(barkodi, emertimi, cmimi, Boolean.parseBoolean(parametrat[4]));
                            break;
                        case "Divani":
                            a = new Divani(barkodi, emertimi, cmimi, parametrat[4]);
                            break;
                        case "Tavolina":
                            a = new Tavolina(barkodi, emertimi, cmimi, parametrat[4]);
                            break;
                    }
                    dyqani.shtoArtikullin(a);
                }
            }
        }catch(IOException ioe){
        }
    }

    public void shtoKlientin(Klienti k) throws BlerjaException{
        if(k == null){
            throw new BlerjaException("Klienti duhet inicializuar");
        }
        if(klientet.contains(k)){
            throw new BlerjaException("Klienti ekziston");
        }
        klientet.add(k);
    }

    public void lexoKlientet() throws BlerjaException{
        try(BufferedReader br = new BufferedReader(new FileReader("F://gent//klientet.txt"))){
            String rreshti;
            while((rreshti = br.readLine()) != null){
                String [] parametrat = rreshti.split(";");
                if(parametrat.length == 3){
                    shtoKlientin(new Klienti(parametrat[0], Integer.parseInt(parametrat[2]), parametrat[1].charAt(0)));
                }
            }
        }catch(IOException ioe){
        }

    }

    public void filloBlerjen() throws BlerjaException{
        Iterator<Klienti> it = klientet.iterator();
        while(it.hasNext()){
            Blerja b = new Blerja(dyqani, it.next());
            new Thread(b).start();
        }
    }

    public static void main(String[] args) {
        try{
            BlackFriday b = new BlackFriday(new Dyqani("Walmart"));
            b.lexoArtikuj();
            b.lexoKlientet();
            b.filloBlerjen();
        }catch(BlerjaException be){
            be.printStackTrace();
        }
    }

}
