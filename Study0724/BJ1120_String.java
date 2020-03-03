package Study0724;

import java.util.Scanner;

public class BJ1120_String {
    static String A, B;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] tmp = scan.nextLine().split(" ");
        A = tmp[0]; B = tmp[1];
        int max = 0;
        for(int i=0;i<=B.length()-A.length(); i++) {
            int same = 0;
            for(int j=0;j<A.length();j++) {
                if(B.charAt(i+j)==A.charAt(j)) {
                    same++;
                }
            }
            if(max<same) {
                max = same;
            }
        }
        System.out.println(A.length()-max);
    }
}
