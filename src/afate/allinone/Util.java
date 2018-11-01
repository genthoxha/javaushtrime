package afate.allinone;

public class Util {
    public static boolean isEmpty(String s) {
        if (s == null || s.trim().equals("")) {
            return true;
        }
        return false;
    }
}
