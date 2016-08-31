import java.math.BigDecimal;
import java.util.Scanner;

public class POJ1001 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            BigDecimal R = in.nextBigDecimal();
            int n = in.nextInt();
            R = R.pow(n);
            String str = R.stripTrailingZeros().toPlainString();
            if (str.startsWith("0."))
                str = str.substring(1);
            System.out.println(str);

        }
    }
}

