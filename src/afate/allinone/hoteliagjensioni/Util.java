package afate.allinone.hoteliagjensioni;

public class Util {
    public static boolean isEmpty(String msg) {
        if (msg == null || msg.trim().isEmpty()) {
            return true;
        }
        return false;
    }
}
