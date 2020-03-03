package Baekjoon;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BJ_2840_LuckyWheel {
    static int n, k;
    static String[] wheel;
    static String result = "";
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); k = in.nextInt();
        in.nextLine();
        wheel = new String[n];
        for(int i=0;i<n;i++) {
            wheel[i] = "?";
        }
        int curr = 0;
        for(int i=0;i<k;i++) {
            String[] line = in.nextLine().split(" ");
            int num = Integer.parseInt(line[0]);
            int target = (curr+num)%n;
//            System.out.println(target);
            if(!wheel[target].equals("?")) { // 같은 자리에
                if(!set.contains(line[1])) {
                    result +="!";
                    break;
                }
            }
            else {
                wheel[target] = line[1];
                set.add(line[1]);
            }
            curr = target;
        }
//        System.out.println(curr);
        if(!result.equals("!")) {
            int c = 0;
//            for(int i=0;i<n;i++) {
//                System.out.print(wheel[i]);
//            }
//            System.out.println();
            for(int i=curr;;i--) {
                if(c==n) break;
                result +=wheel[(i+n)%n];
                c++;
            }
        }
        System.out.println(result);
    }
}
