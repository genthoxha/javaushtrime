package afate.allinone.hoteliagjensioni;

public interface llojiUshqimit {

    public enum Vakti {

        Mengjes("Mengjesi",5),
        Dreka("Dreka", 5),
        Darka("Darka", 5);


        private String lloji;
        private int cmimi;

        private Vakti(String lloji,int cmimi) {
            this.lloji = lloji;
            this.cmimi = cmimi;
        }
    }




}
