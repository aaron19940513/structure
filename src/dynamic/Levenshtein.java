package dynamic;
/**
 * @author sam
 * @date 09/27/19 9:22
 */
public class Levenshtein {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "def";
        String s3 = "ALGORITHM";
        String s4 = "ALTRUISTIC";
        String s5 = "abc";
        String s6 = "bcde";
        // int editDistance = levenshtein(s1, s2);
        // System.out.println("s1=" + s1 + "与s2=" + s2 + "的编辑距离为：" + editDistance);
        //
        // editDistance = levenshtein(s3, s4);
        // System.out.println("s3=" + s3 + "与s4=" + s4 + "的编辑距离为：" + editDistance);

        int editDistance = levenshtein(s5, s6);
        System.out.println("s5=" + s6 + "与s4=" + s6 + "的编辑距离为：" + editDistance);
    }

    /**
     * 编辑距离求解
     *
     * @param s1 字符串s1
     * @param s2 字符串s2
     * @return 编辑距离
     */
    private static int levenshtein(String s1, String s2) {
        int i = 0;  //s1字符串中的字符下标
        int j = 0;  //s2字符串中的字符下标
        char s1i = 0;   //s1字符串第i个字符
        char s2j = 0;   //s2字符串第j个字符
        int m = s1.length();    //s1字符串长度
        int n = s2.length();    //s2字符串长度
        if (m == 0) {   //s1字符串长度为0，此时的编辑距离就是s2字符串长度
            return n;
        }
        if (n == 0) {
            return m;   //s2字符串长度为0，此时的编辑距离就是s1字符串长度
        }
        int[][] solutionMatrix = new int[m + 1][n + 1];     //求解矩阵
        /**
         *      d e f
         *   |0|x|x|x|
         * a |1|x|x|x|
         * b |2|x|x|x|
         * c |3|x|x|x|
         */
        for (i = 0; i < m + 1; i++) {
            solutionMatrix[i][0] = i;
        }
        /**
         *      d e f
         *   |0|1|2|3|
         * a |x|x|x|x|
         * b |x|x|x|x|
         * c |x|x|x|x|
         */
        for (j = 0; j < n + 1; j++) {
            solutionMatrix[0][j] = j;
        }
        /**
         * 上面两个操作后，求解矩阵变为
         *      d e f
         *   |0|1|2|3|
         * a |1|x|x|x|
         * b |2|x|x|x|
         * c |3|x|x|x|
         * 接下来就是填充剩余表格
         */
        for (i = 1; i < m + 1; i++) {   //i = 1,j = 1, 2, 3，以行开始填充
            s1i = s1.charAt(i - 1);
            for (j = 1; j < n + 1; j++) {
                s2j = s2.charAt(j - 1);
                int flag = (s1i == s2j) ? 0 : 1;
                //根据公式，如果s1[i] = s2[j]，则d[i,j]=d[i-1,j-1]，如果s1[i] ≠ s2[j]，则其中一个公式为d[i,j]=d[i-1,j-1]+1
                solutionMatrix[i][j] = min(solutionMatrix[i][j - 1] + 1, solutionMatrix[i - 1][j] + 1, solutionMatrix[i - 1][j - 1] + flag);
            }
        }
        return solutionMatrix[m][n];
    }

    /**
     * 根据公式求解编辑距离
     *
     * @param insert s1插入操作
     * @param delete s1删除操作
     * @param edit   s1修改操作
     * @return 编辑距离
     */
    private static int min(int insert, int delete, int edit) {
        int tmp = insert < delete ? insert : delete;
        return tmp < edit ? tmp : edit;
    }
}
