package afate.allinone.hoteliagjensioni;


public interface LlojiUshqimit {

    enum Lloji {
        Mengjesi("Mengjesi", 20),
        Dreka("Dreke", 20),
        Darka("Darke", 20);


        private String lloji;
        private double cmimi;

        Lloji(String lloji, int cmimi) {
            this.lloji = lloji;
            this.cmimi = cmimi;
        }

        public String getLloji() {
            return lloji;
        }

        public void setLloji(String lloji) {
            this.lloji = lloji;
        }

        public double getCmimi() {
            return cmimi;
        }

        public void setCmimi(int cmimi) {
            this.cmimi = cmimi;
        }

        @Override
        public String toString() {
            return "Lloji: " + lloji + " ka cmimin: " + cmimi;
        }


    }

}
