package array;
/**
 * @author sam
 * @date 10/14/19 13:54
 */
public class DutchNationalFlagProblem {
    public static void main(String[] args) {
        int[] a = new int[] {1, 1, 0, 2, 2, 1, 0, 0, 2, 2, 1, 1, 0, 0, 2, 1, 0, 1, 0, 2, 1, 0};
        solve(a);
    }

    private static void solve(int[] a) {
        if (a.length <= 1) {
            return;
        }
        int begin = 0;
        int current = 0;
        int end = a.length - 1;
        while (current < end) {
            if (a[current] == 0) {
                int temp = a[begin];
                a[begin] = 0;
                a[current] = temp;
                begin++;
                current++;
            } else if (a[current] == 1) {
                current++;
            } else {
                int temp = a[end];
                a[end] = 2;
                a[current] = temp;
                end--;
            }
        }
        for (int i : a) {
            System.out.printf("%d ",i);
        }
    }
}
