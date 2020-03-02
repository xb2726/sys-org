package sys.org.util;

import sys.org.model.Org;

import java.util.Random;

/**
 * @author 27267
 */
public class StringUtils {

    public static boolean isEmpty(String a) {
        return a == null || "".equals(a.trim());
    }

    public static boolean isNotEmpty(String a) {
        return !isEmpty(a);
    }

    public static String random(int length) {
        String arr = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        String result = "";
        for (int j = 0; j < length; j++) {
            result += arr.charAt(random.nextInt(36));
        }
        return result;
    }
}
