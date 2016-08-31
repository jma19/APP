import java.util.*;

public class POJ1002 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, Integer> resultMap = new HashMap<String, Integer>();

        int number = in.nextInt();
        boolean isDublicate = false;
        for (int i = 0; i < number; i++) {
            String input = in.next();
            String result = mapToTeleNUmber(input);
            if (resultMap.containsKey(result)) {
                Integer integer = resultMap.get(result);
                resultMap.put(result, integer + 1);
                isDublicate = true;
            } else {
                resultMap.put(result, 1);
            }
        }
        if (isDublicate) {
            printMoreThanOnce(resultMap);
        } else {
            System.out.println("No duplicates.");
        }
    }

    public static void printMoreThanOnce(Map<String, Integer> map) {
        Set<String> strings = map.keySet();
        Object[] printStrings = strings.toArray();
        Arrays.sort(printStrings);
        for (Object string : printStrings) {
            Integer integer = map.get(string);
            if (integer > 1) {
                System.out.println(string + " " + integer);
            }
        }
    }


    public static String mapToTeleNUmber(String input) {
        char[] chars = input.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (char ch : chars) {
            if (isDigit(ch)) {
                stringBuffer.append(ch);
            } else if (isChar(ch)) {
                stringBuffer.append(mapToNumber(ch));
            }
            if (stringBuffer.length() == 3) {
                stringBuffer.append("-");
            }
        }

        String result = stringBuffer.toString().trim();
        if (result.length() != 8) {
            return null;
        }
        return result;
    }


    public static boolean isChar(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }

    public static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    private static int mapToNumber(char c) {
        if (c == 'A' || c == 'B' || c == 'C') return 2;
        else if (c == 'D' || c == 'E' || c == 'F') return 3;
        else if (c == 'G' || c == 'H' || c == 'I') return 4;
        else if (c == 'J' || c == 'K' || c == 'L') return 5;
        else if (c == 'M' || c == 'N' || c == 'O') return 6;
        else if (c == 'P' || c == 'R' || c == 'S') return 7;
        else if (c == 'T' || c == 'U' || c == 'V') return 8;
        else return 9;
    }
}
