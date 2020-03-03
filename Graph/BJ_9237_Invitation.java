package Graph;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BJ_9237_Invitation {
    static Scanner in = new Scanner(System.in);
    static int n;
    static Integer[] tree = new Integer[100000];
    static int max = 0;
    public static void main(String[] args) {
        n = in.nextInt();
        tree = new Integer[n];
        for(int i=0;i<n;i++) {
            tree[i] = in.nextInt();
        }
//        거꾸로 정렬
        Arrays.sort(tree,Collections.reverseOrder());
//        for(int i=0;i<n;i++) {
//            System.out.println(tree[i]);
//        }
        for(int i=0;i<n;i++) {
            max = Math.max(max, i+tree[i] + 1);
        }
        System.out.println(max+1);
    }
}
