import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        Scanner in = new Scanner(System.in);
        int col = in.nextInt();
        for(int i = 0; i < col; i++){
            //每读一次的处理
            StringBuffer sb = new StringBuffer();
            String next = in.next();
            int len = next.length();
            for(int j = 0; j < len; j++){
                char nc = next.charAt(j);
                if(nc!='-'){
                    int gm = 0;
                    if(nc>='0'&&nc<='9')gm = (nc-48);
                    else gm = getNum(nc);
                    sb.append(gm);
                }
            }
            String key = sb.toString();
            if(hm.containsKey(key)){
                hm.put(key, hm.get(key)+1);
            }else{
                hm.put(key, 1);
            }
            sb.setLength(0);
        }
        Object[] keys = hm.keySet().toArray();
        Arrays.sort(keys);
        boolean b = false;
        for(Object k : keys){
            String kk = (String)k;
            if(hm.get(kk)>1){
                b = true;
                System.out.println(kk.substring(0,3) + "-" + kk.substring(3) + " "+hm.get(kk));
            }
        }
        if(!b){
            System.out.println("No duplicates.");
        }
    }
    private static int getNum(char c){
        if(c=='A'||c=='B'||c=='C')return 2;
        else if(c=='D'||c=='E'||c=='F')return 3;
        else if(c=='G'||c=='H'||c=='I')return 4;
        else if(c=='J'||c=='K'||c=='L')return 5;
        else if(c=='M'||c=='N'||c=='O')return 6;
        else if(c=='P'||c=='R'||c=='S')return 7;
        else if(c=='T'||c=='U'||c=='V')return 8;
        else return 9;
    }
}