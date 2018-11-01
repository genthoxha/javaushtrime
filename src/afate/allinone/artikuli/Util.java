package afate.allinone.artikuli;

public class Util {
    public static boolean isEmpty(String s) {
        if (s == null || s.trim().equals("")) {
            return true;
        }
        return false;
    }
}
