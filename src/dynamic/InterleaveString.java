package dynamic;
/**
 * @author sam
 * @date 10/22/19 15:15
 */
public class InterleaveString {
    public static void main(String[] args) {
        // String a = "ab";
        // String b = "cd";
        // String c = "cdab";
        // System.out.println(isInterleave(a, b, c));
        String a = "aabcc";
        String b = "dbbca";
        String c = "aadbbcbcac";
        System.out.println(isInterleave(a, b, c));


    }

    private static boolean isInterleave(String a, String b, String c) {
        int n = a.length();
        int m = b.length();
        int s = c.length();
        if (n + m != s) {
            return false;
        }

        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        System.out.println("****************matrix*****************");
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (dp[i][j] || (i - 1 >= 0 && dp[i - 1][j] && a.charAt(i - 1) == c.charAt(i + j - 1))
                    || (j - 1 >= 0 && dp[i][j - 1] && b.charAt(j - 1) == c.charAt(i + j - 1))) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = false;
                }
                System.out.printf("%10s", dp[i][j]);
            }
            System.out.println();
        }


        System.out.println("****************matrix*****************");
        return dp[n][m];
    }
}
