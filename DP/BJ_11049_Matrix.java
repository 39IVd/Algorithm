package DP;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BJ_11049_Matrix {
    static Scanner in = new Scanner(System.in);
    static int n;
    static List<Long> list = new LinkedList<>();
    static long res = 0;
    public static void main(String[] args) {
        n = in.nextInt();
        list.add(in.nextLong());
        for(int i=0;i<n-1;i++) {
            list.add(in.nextLong());
            in.nextInt();
        }
        list.add(in.nextLong());
        while(list.size()>2) {
            long max = 0;
            int maxIndex = 0;
            for(int i=1;i<list.size()-1;i++) {
                if(max<list.get(i)) {
                    max = list.get(i);
                    maxIndex = i;
                }
            }
//            System.out.println(maxIndex+", "+max);
            res += list.get(maxIndex-1)*list.get(maxIndex)*list.get(maxIndex+1);
            list.remove(maxIndex);
        }
        System.out.println(res);
    }
}
