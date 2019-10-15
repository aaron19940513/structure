package array;
/**
 * 跳台阶问题
 * 题目描述
 * 一个台阶总共有n 级，如果一次可以跳1 级，也可以跳2 级。
 * 求总共有多少总跳法，并分析算法的时间复杂度。
 *
 * @author sam
 * @date 10/10/19 10:34
 */
public class FibonacciSequence {
    public static void main(String[] args) {
        int total = 5;
        System.out.println(solve(total));

    }

    private static int solve(int total) {
        if (total == 1) {
            return 1;
        } else if (total == 2) {
            return 2;
        } else {
            return solve(total - 1) + solve(total - 2);
        }
    }
}
