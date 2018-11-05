package afate.allinone.detyrateshtepise.Artikulli;


import java.util.Objects;

public abstract class Artikulli {
    private int barkodi; //readonly
    private String emertimi;
    private double cmimi;

    public Artikulli(int barkodi, String emertimi, double cmimi) throws BlerjaException{
        if(barkodi <= 0){
            throw new BlerjaException("Barkodi duhet te jete pozitiv");
        }
        this.barkodi = barkodi;
        if(emertimi == null || emertimi.trim().isEmpty()){
            throw new BlerjaException("Emertimi nuk duhet te jete i zbrazet");
        }
        this.emertimi = emertimi;
        if(cmimi <= 0){
            throw new BlerjaException("Cmimi duhet te jete pozitiv");
        }
        this.cmimi = cmimi;
    }

    public int getBarkodi() {
        return barkodi;
    }

    public String getEmertimi() {
        return emertimi;
    }

    public double getCmimi() {
        return cmimi;
    }

    public void setCmimi(int cmimi) throws BlerjaException{
        if(cmimi <= 0){
            throw new BlerjaException("Cmimi duhet te jete pozitiv");
        }
        this.cmimi = cmimi;
    }

    public abstract boolean montohet();

    @Override
    public String toString(){
        return barkodi+"-"+emertimi+":"+cmimi;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Artikulli){
            return ((Artikulli)obj).getBarkodi() == barkodi;
        }
        return false;
    }




}

