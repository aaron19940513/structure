package string;
/**
 * @author sam
 * @date 09/26/19 14:28
 */
public class palindrome {

    public static final String palindrome = "admda";

    public static final String nonPalindrome = "admdda";

    public static void main(String[] args) {
        // System.out.println(palindrome + " is palindrome " + clamp(palindrome));
        // System.out.println(nonPalindrome + " is palindrome " + clamp(nonPalindrome));
        // System.out.println("------------ -----------");
        // System.out.println(palindrome + " is palindrome " + dispersion(palindrome));
        // System.out.println(nonPalindrome + " is palindrome " + dispersion(nonPalindrome));
        // System.out.println("------------ -----------");
        System.out.println(palindrome + " is palindrome " + isPalindrome("ab2a"));
        System.out.println(nonPalindrome + " is palindrome " + isPalindrome(nonPalindrome));
    }

    public static boolean clamp(String a) {
        char[] charArray = a.toCharArray();
        int start = 0;
        int end = charArray.length - 1;
        while (start < end) {
            if (charArray[start] != charArray[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean dispersion(String a) {
        char[] charArray = a.toCharArray();
        int length = charArray.length;

        int start = ((length >> 1) - 1) >= 0 ? (length >> 1) - 1 : 0;
        int end = length - 1 - start;

        while (start >= 0) {
            if (charArray[start] != charArray[end]) {
                return false;
            }
            start--;
            end++;
        }
        return true;
    }

    public static boolean isPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int start = 0;
        int end = charArray.length - 1;
        while (start < end) {
            if (!(('a' <= charArray[start] && charArray[start] <= 'z')
                  || ('A' <= charArray[start] && charArray[start] <= 'Z')
                  || ('0' <= charArray[start] && charArray[start] <= '9'))) {
                start++;
                continue;
            }
            if (!(('a' <= charArray[end] && charArray[end] <= 'z')
                  || ('A' <= charArray[end] && charArray[end] <= 'Z')
                  || ('0' <= charArray[end] && charArray[end] <= '9'))) {
                end--;
                continue;
            }
            if (('0' <= charArray[start] && charArray[start] <= '9') || ('0' <= charArray[end] && charArray[end] <= '9')) {
                if (charArray[start] != charArray[end]) {
                    return false;
                }
            }
            if ((charArray[start] - charArray[end]) % 32 != 0) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
