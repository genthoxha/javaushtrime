package afate.allinone.pajisja;

public class Email implements Komunikimi {

    private String mesazhi;
    private String adresa;
    private boolean kaBashkangjitje;

    public Email(String mezazhi, String adresa, boolean kaBashkangjitje) throws PajisjaException {
        if (mezazhi == null || mezazhi.trim().isEmpty()) {
            throw new PajisjaException("Email: Mesazhi eshte null!");
        }
        if (adresa == null || adresa.trim().isEmpty()) {
            throw new PajisjaException("Email: Adresa eshte null!");
        }
        this.mesazhi = mezazhi;
        this.adresa = adresa;
        this.kaBashkangjitje = kaBashkangjitje;
    }

    @Override
    public void dergoMesazhin(String mesazhi, String adresa, boolean kaBashkangjitje) {
        System.out.println("Komunikimi permes email: " + mesazhi + " : " + adresa + (kaBashkangjitje ? "Ka bashkangjitje" : "Ska bashkangjitje"));
    }

}
