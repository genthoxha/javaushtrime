package afate.allinone.pajisja;

public class Viber implements Komunikimi {
    private String mesazhi;
    private String adresa;
    private boolean ka;

    public Viber(String mesazhi, String adresa, boolean kaBashkangjitje) throws PajisjaException {
        if (mesazhi == null || adresa.trim().isEmpty()) {
            throw new PajisjaException("VIBER: Mesazhi null");
        }
        if (adresa == null || adresa.trim().isEmpty()) {
            throw new PajisjaException("VIBER: Mesazhi null");
        }
        this.mesazhi = mesazhi;
        this.adresa = adresa;
        this.ka = kaBashkangjitje;
    }

    @Override
    public void dergoMesazhin(String mesazhi, String adresa, boolean kaBashkangjitje) {
        System.out.println("Komunikimi permes Viber: " + mesazhi + " : " + adresa + (kaBashkangjitje ? "Ka bashkangjitje" : "Ska Bashkangjitje"));
    }
}
