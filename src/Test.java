import java.util.Arrays;
import java.util.List;

/**
 * @author sam
 * @date 10/22/19 17:06
 */
public class Test {
    public static void main(String[] args) {
        // Timer timer = new Timer();
        // timer.schedule(new TimerTask() {
        //     @Override
        //     public void run() {
        //         System.out.println("test1");
        //     }
        // }, 5000);
        // timer.schedule(new TimerTask() {
        //     @Override
        //     public void run() {
        //         System.out.println("test2");
        //     }
        // }, 3000);
        // System.out.println(Math.floor(0.6));
        System.out.println(back("2019-12-31", 6));
        System.out.println(back("2019-06-31", 18));
        System.out.println(back("2019-06-31", 19));
        System.out.println(back("2019-07-31", 41));
        System.out.println(back("2019-07-1", 5));
    }

    private static String back(String date, int backMonth) {
        int year = Integer.valueOf(date.substring(0, 4));
        int month = Integer.valueOf(date.substring(5, 7));
        int day = Integer.valueOf(date.substring(8));
        int resultYear = year + (int) Math.floor((month - backMonth) / 12F);
        int resultMonth = (month - backMonth + 120) % 12 == 0 ? 12 : (month - backMonth + 120) % 12;
        if (resultMonth == 12) {
            resultYear--;
        }
        int resultDay;
        List<Integer> bigMonth = Arrays.asList(new Integer[] {1, 3, 5, 7, 8, 10, 12});
        List<Integer> shortMonth = Arrays.asList(new Integer[] {4, 6, 9, 11});

        if (resultMonth == 2 && day > 28) {
            if ((resultYear % 4 == 0 && resultYear % 100 != 0) || resultYear % 400 == 0) {
                resultDay = 28;
            } else {
                resultDay = 29;
            }

        } else if (day == 31 && shortMonth.contains(resultMonth)) {
            resultDay = 30;
        } else {
            resultDay = day;
        }
        return resultYear + "-" + resultMonth + "-" + resultDay;
    }
}
