package string;
/**
 * @author sam
 * @date 09/26/19 13:35
 */
public class StringContain {
    public static final String bigString = "ABCDEFGHIJKLMNOPQRST";

    public static final String shortString = "BC";

    public static final String notContain = "BFC";

    public static void main(String[] args) {
        System.out.println("String contain:" + stringContain(bigString.toCharArray(), shortString.toCharArray()));
        System.out.println("String contain:" + stringContain(bigString.toCharArray(), notContain.toCharArray()));
    }

    static Boolean stringContain(char[] a, char[] b) {
        int hash = 0;
        for (int i = 0; i < a.length; ++i) {
            hash |= (1 << (a[i] - 'A'));
        }
        for (int i = 0; i < b.length; ++i) {
            if ((hash & (1 << (b[i] - 'A'))) == 0) {
                return false;
            }
        }
        return true;
    }

}
