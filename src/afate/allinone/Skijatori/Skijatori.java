/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afate.allinone.Skijatori;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fatos
 */
public class Skijatori implements Comparable<Skijatori>{
    private int shifra;
    private String emri;
    private String shteti;
    private List <Disciplina.Alpin> disciplinat;

    public Skijatori(int shifra, String emri, String shteti) throws FisException{
        if(shifra <=0){
            throw new FisException("shifra duhet te jete pozitive");
        }
        
        if(Util.isEmpty(emri)) {
            throw new FisException("emri i skijatori eshte i zbrazte");
        }
        
        if(Util.isEmpty(shteti) && shteti.trim().length() != 3) {
            throw new FisException("shteti i dhene jo i sakte");
        }
        this.shifra = shifra;
        this.emri = emri;
        this.shteti = shteti;
        disciplinat = new ArrayList<>();
    }
    
    public String getEmri(){
        return emri;
    }
    
    public void shtoDisciplinen(Disciplina.Alpin disc) throws FisException {
        if(disc == null) {
            throw new FisException("Disciplina e dhene eshte NULL");
        }
        if(disciplinat.contains(disc)) {
            throw new FisException("Disciplina e dhene ekziston");
        }
        disciplinat.add(disc);
    }
    
    public boolean iTakonDisciplines(Disciplina.Alpin disc) {
        return disc != null && disciplinat.contains(disc);
    }

    @Override
    public String toString() {
        return shifra + ") " + emri + ": " + shteti;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Skijatori) {
            final Skijatori skijatori = (Skijatori)obj;
            return shifra == skijatori.shifra;
        }
        return false;
    }

    @Override
    public int compareTo(Skijatori o) {
        return shifra - o.shifra;
    }
}
