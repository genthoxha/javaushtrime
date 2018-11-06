/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afate.allinone.Skijatori;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Fatos
 */
public class Gara {
    private String emri;
    private Disciplina.Alpin disciplina;
    private List <Skijatori> skijatoret;
    private HashMap <Integer, List <Skijatori>> rezulati;
    private Random rand;
    
    public Gara(String emri, Disciplina.Alpin disc) throws FisException {
        if(Util.isEmpty(emri)) {
            throw new FisException("emri i vendit te gares eshte i zbrazte");
        }        
        if(disc == null){
            throw new FisException("Disciplina eshte NULL");
        }
        this.emri = emri;
        this.disciplina = disc;
        skijatoret = new ArrayList<>();
        rezulati = new HashMap<>();
        rand = new Random();
        
    }
    
    public void shtoSkijatoin(Skijatori skijatori) throws FisException {
        if(skijatori == null) {
            throw new FisException("Skijatori eshte NULL");
        }        
        
        if(!skijatori.iTakonDisciplines(disciplina)) {
            throw new FisException("Skijatori nuk i takon gares");
        }
        
        if(skijatoret.contains(skijatori)) {
            throw new FisException("Skijatori eshte ne liste");
        }
        skijatoret.add(skijatori);
    }
    
    public void startoGaren(){
        Iterator <Skijatori> it = skijatoret.iterator();
        while(it.hasNext()) {
            Skijatori skijatori = it.next();
            int koha = kohaELeshimit();
            System.out.println(skijatori+" filloi leshimin "+koha );
            try {
                Thread.sleep(koha * 100);
            } catch (InterruptedException ex) {               
            }
            it.remove();
            if(koha < 10) {
                System.out.println(skijatori+" u rrezua");
            } else {
                System.out.println(skijatori+" perfundoi leshimin per "+koha+" sekonda");
                List <Skijatori> skijatorerPerKohe = rezulati.get(koha);
                if(skijatorerPerKohe == null) {
                    skijatorerPerKohe = new ArrayList<>();
                }
                skijatorerPerKohe.add(skijatori);
                rezulati.put(koha, skijatorerPerKohe);        
            }
        }
    }
    
    public boolean garaKaPerfunduar(){
        return skijatoret.isEmpty();
    }
    
    public Skijatori ktheFituesin() {
        if(!garaKaPerfunduar()) {
            return null;
        }
        Set <Integer> set = rezulati.keySet();
        if(set.isEmpty()) {
            return null;
        }
        Integer [] arr = new Integer[set.size()];        
        arr = set.toArray(arr);
        Arrays.sort(arr);
        //ose 
//        List <Integer> keys = new ArrayList<>(set);
//        Collections.sort(keys);
//        Integer ePara = keys.get(0);
        
        List <Skijatori> skijatorerPerKohe = rezulati.get(arr[0]);
        Collections.sort(skijatorerPerKohe);
        return skijatorerPerKohe.get(0);
    }
    
    public void populloPrejFile() throws IOException{
        try (BufferedReader br = new BufferedReader(new FileReader("D:/skijatoret.txt"))){
            String rreshti;
            while((rreshti = br.readLine()) != null){
                try {
                    Skijatori skijatori = ndertoNgaRreshti(rreshti);
                    if(skijatori != null) {
                        skijatoret.add(skijatori);
                    }
                }
                catch(FisException fe) {
                    System.out.println("Nuk u shtua: "+rreshti);
                }
            }
        }
    }
    
    private Skijatori ndertoNgaRreshti(String rreshti) throws FisException{
        String [] params = rreshti.split(",");
        Skijatori skijatori = null;
        if(params.length == 4) {            
            try {
                int shifra = Integer.parseInt(params[0]);
                String emriStr = params[1].trim();
                String shteti = params[2].trim();
                skijatori = new Skijatori(shifra, emriStr, shteti);
                String disciplinaStr = params[3].trim();
                String [] disciplinat = disciplinaStr.split(":");
                for (String disc : disciplinat) {
                    switch(disc) {
                        case "D":
                            skijatori.shtoDisciplinen(Disciplina.Alpin.Downhill);
                            break;
                        case "S":
                            skijatori.shtoDisciplinen(Disciplina.Alpin.Slalom);
                            break;
                        case "GS":
                            skijatori.shtoDisciplinen(Disciplina.Alpin.GiantSlalom);
                            break;
                    }
                }
            } catch(NumberFormatException nfe){}
        }
        return skijatori;
    }
    
    private int kohaELeshimit(){
        return rand.nextInt(60);                
    }
    
    public static void main(String[] args) {
        try {
            Gara gara = new Gara("Schladming", Disciplina.Alpin.Slalom);
            gara.populloPrejFile();
            gara.startoGaren();
            System.out.println("Fituesi = " + gara.ktheFituesin());
        } catch (FisException | IOException ex) {
            System.out.println(ex);
        }
    }
}