package string;
/**
 * 字符串全排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 例如输入字符串abc，则输出由字符a、b、c 所能排列出来的所有字符串
 * abc、acb、bac、bca、cab 和 cba。
 *
 * @author sam
 * @date 09/27/19 14:50
 */
public class FullyArranged {
    public static void main(String[] args) {
        String a = "12345";
        calcAllPermutation(a.toCharArray());

    }

    static void calcAllPermutation(char[] a) {
        int length = a.length;
        int index_x = a.length - 2;
        while (index_x >= 0) {
            if (a[index_x] < a[index_x + 1]) {
                break;
            }
            index_x--;
        }
        if (index_x < 0) {
            return;
        }
        int index_y = a.length - 1;
        while (index_y > index_x) {
            if (a[index_y] > a[index_x]) {
                break;
            }

            index_y--;
        }

        swap(a, index_x, index_y);
        reverse(a, index_x + 1, index_y);
        for (char character : a) {
            System.out.print(character);
        }
        System.out.println();
        calcAllPermutation(a);
    }


    private static void swap(char[] a, int index_x, int index_y) {
        char swap = a[index_x];
        a[index_x] = a[index_y];
        a[index_y] = swap;
    }

    private static void reverse(char[] a, int start, int end) {
        while (start < end) {
            swap(a, start, end);
            start++;
            end--;
        }
    }
}
