package array;
/**
 * 完美洗牌算法
 * 题目详情
 * 有个长度为2n的数组{a1,a2,a3,...,an,b1,b2,b3,...,bn}，希望排序后{a1,b1,a2,b2,....,an,bn}，请考虑有无时间复杂度o(n)，空间复杂度0(1)的解法。
 *
 * @author sam
 * @date 10/14/19 15:39
 */
public class PerfectShuffle {
    public static void main(String[] args) {
        String[] a = new String[] {"", "a1", "a2", "a3", "a4", "b1", "b2", "b3", "b4"};
        solve1(a);
        String[] b = new String[] {"", "a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "a9", "a10",
            "b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8", "b9", "b10"};
        solve2(b);
    }


    /**
     * 第1个元素a1到了原第2个元素a2的位置，即1->2；
     * 第2个元素a2到了原第4个元素a4的位置，即2->4；
     * 第3个元素a3到了原第6个元素b2的位置，即3->6；
     * 第4个元素a4到了原第8个元素b4的位置，即4->8；
     *
     *
     * > 第5个元素b1到了原第1个元素a1的位置，即5->1；
     * > 第6个元素b2到了原第3个元素a3的位置，即6->3；
     * > 第7个元素b3到了原第5个元素b1的位置，即7->5；
     * > 第8个元素b4到了原第7个元素b3的位置，即8->7；
     *
     * 它的时间复杂度虽然是O(n)，但其空间复杂度却是O(n)
     */
    private static void solve1(String[] a) {
        int n = (a.length - 1) / 2;
        String[] b = new String[2 * n + 1];
        for (int index = 1; index <= 2 * n; index++) {
            b[(2 * index) % (2 * n + 1)] = a[index];
        }
        for (int index = 1; index <= 2 * n; index++) {
            a[index] = b[index];
        }

        for (String s : a) {
            System.out.printf("%s ", s);
        }
    }

    /**
     * 神级结论：若2*n=（3^k - 1），则可确定圈的个数及各自头部的起始位置
     */
    private static void solve2(String[] a) {
        int n = (a.length - 1) / 2;
        // n = 1
        if (n == 1) {
            String temp = a[1];
            a[1] = a[2];
            a[2] = temp;
        }

        int n2, m, i, k, t;
        for (; n > 1; ) {
            // step 1
            n2 = n * 2;
            int startIndex = a.length - 1 - n2;
            for (k = 0, m = 1; n2 / m >= 3; ++k, m *= 3) {
                ;
            }
            m /= 2;
            // 2m = 3^k - 1 , 3^k <= 2n < 3^(k + 1)

            // step 2
            rightRotate(a, m, n, startIndex);

            // step 3
            for (i = 0, t = 1; i < k; ++i, t *= 3) {
                cycleLeader(a, t, m * 2 + 1, startIndex);
            }

            //step 4
            n -= m;

        }


        System.out.println();
        for (String s : a) {
            System.out.printf("%s ", s);
        }

    }


    private static void rightRotate(String[] a, int m, int n, int startIndex) {
        reverse(a, m + 1 + startIndex, n + startIndex);
        reverse(a, n + 1 + startIndex, n + m + startIndex);
        reverse(a, m + 1 + startIndex, n + m + startIndex);
    }

    private static void reverse(String[] a, int from, int to) {
        String t;
        for (; from < to; ++from, --to) {
            t = a[from];
            a[from] = a[to];
            a[to] = t;
        }
    }

    private static void cycleLeader(String[] a, int from, int mod, int startIndex) {
        int i;
        String t;

        for (i = from * 2 % mod; i != from; i = i * 2 % mod) {
            t = a[i + startIndex];
            a[i + startIndex] = a[from + startIndex];
            a[from + startIndex] = t;
        }
    }
}
