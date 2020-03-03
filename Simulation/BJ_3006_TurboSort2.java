package Simulation;

import java.util.*;

public class BJ_3006_TurboSort2 {
    static int n;
    static List<Integer> list = new LinkedList<>();
    static int[] arr = new int[100000];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for(int i=0;i<n;i++) {
            list.add(in.nextInt());
        }
        int minN = 1, maxN = n;
//        System.out.print("initial : ");
//        for(int i=0;i<list.size();i++) {
//            System.out.print(list.get(i)+" ");
//        }
//        System.out.println();
        for(int level=1;level<=n;level++) {
            if(level%2==1) { // odd level
                System.out.println(list.indexOf(minN)-minN+1);
                list.remove(list.indexOf(minN));
                list.add(minN-1, minN);
                minN++;

            }
            else {
                System.out.println(maxN-list.indexOf(maxN)-1);
                list.remove(list.indexOf(maxN));
                list.add(maxN-1, maxN);
                maxN--;

            }
//            System.out.print(level+"th : ");
//            for(int i=0;i<list.size();i++) {
//                System.out.print(list.get(i)+" ");
//            }
//            System.out.println();
        }
    }
}
