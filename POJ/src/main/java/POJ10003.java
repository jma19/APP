import java.util.Scanner;

public class POJ10003 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double v = in.nextDouble();
        while (v!=0.00){
            int cardsNmberByResult = getCardsNmberByResult(v);
            System.out.println(cardsNmberByResult+" card(s)");
            v=in.nextDouble();
        }
    }

    public static int getCardsNmberByResult(final double result) {
        double tempResult = 0;
        int numberOfCards = 1;

        while (tempResult < result) {
            tempResult += 1 / (double)(numberOfCards + 1);
            numberOfCards += 1;
        }
        return numberOfCards-1;
    }

}

