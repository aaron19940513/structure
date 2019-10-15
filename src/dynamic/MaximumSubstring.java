package dynamic;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sam
 * @date 09/26/19 16:37
 */
public class MaximumSubstring {
    public static List<Double> param = new ArrayList<>();


    public static void main(String[] args) {
        param.add(-2.5D);
        param.add(4D);
        param.add(0D);
        param.add(3D);
        param.add(0.5D);
        param.add(8D);
        param.add(-1D);
        System.out.println(maxProductSubstring(param.toArray(new Double[0])));
    }

    static double maxProductSubstring(Double[] a) {
        int length = a.length;
        double maxEnd = a[0];
        double minEnd = a[0];
        double maxResult = a[0];
        for (int i = 1; i < length; ++i) {
            double end1 = maxEnd * a[i], end2 = minEnd * a[i];
            maxEnd = Double.max(Double.max(end1, end2), a[i]);
            minEnd = Double.min(Double.min(end1, end2), a[i]);
            maxResult = Double.max(maxResult, maxEnd);
        }
        return maxResult;
    }

}
