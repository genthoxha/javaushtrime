package afate.allinone.pajisja;

public class SMS implements Komunikimi{

    @Override
    public void dergoMesazhin(String mes, String adr, boolean kaBashkangjitje) {
        System.out.println("Komunikimi permes SMS: "+mes +" - "+ adr + "Ska bashkangjitje");
    }

}
