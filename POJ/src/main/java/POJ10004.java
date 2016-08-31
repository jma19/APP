import java.text.DecimalFormat;
import java.util.Scanner;

public class POJ10004 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        for (int i = 0; i < 12; i++) {
            double v = scanner.nextDouble();
            sum += v;
        }
        DecimalFormat df = new DecimalFormat(".00");

        System.out.println("$" + df.format(sum / 12));

    }
}
