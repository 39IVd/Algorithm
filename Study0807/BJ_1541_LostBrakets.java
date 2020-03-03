package Study0807;

import java.util.Scanner;

public class BJ_1541_LostBrakets {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        if(str.contains("+")) {
            str = str.replace("+", "=");
        }

        String[] s = str.split("-");
        int result = 0; int val = 0;
        if(str.startsWith("-")) {
            for(int i=1;i<s.length;i++) {
                String[] plus = s[i].split("=");
                for(int j=0;j<plus.length;j++) {
                    val += Integer.parseInt(plus[j]);
                }
                result -= val; val = 0;
            }
        }
        else {
            String[] plus = s[0].split("=");
            for(int j=0;j<plus.length;j++) {
                val += Integer.parseInt(plus[j]);
            }
            result += val; val = 0;
            for(int i=1;i<s.length;i++) {
                plus = s[i].split("=");
                for(int j=0;j<plus.length;j++) {
                    val += Integer.parseInt(plus[j]);
                }
                result -= val; val = 0;
            }
        }
        System.out.println(result);
    }
}
