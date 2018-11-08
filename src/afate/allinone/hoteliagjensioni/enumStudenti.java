package afate.allinone.hoteliagjensioni;

public enum enumStudenti {


    Filani(2, "Filan"),
    Filanja(3, "Filanja");

    private int id;
    private String emri;

    private static final int a = 2;

    private enumStudenti(int id, String emri) {
        this.id = id;
        this.emri = emri;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }
}
