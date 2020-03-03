package Graph;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BJ_1068_Tree {
    static Scanner in = new Scanner(System.in);
    static int n;
    static int[] parent = new int[50];
    static boolean[] leaf = new boolean[50];
    static Set<Integer> set = new HashSet<>();
    static int target;
    public static void main(String[] args) {
        n = in.nextInt();
        for(int i=0;i<n;i++) {
            parent[i] = in.nextInt();
        }
        target = in.nextInt();
        parent[target] = -2;
        for(int i=0;i<n;i++) {
            if(parent[i]==target) {
                parent[i] = -2;
            }
        }
        for(int i=0;i<n;i++) {
            System.out.print(parent[i]+" ");
        }
        System.out.println();
        int res = n;
        for(int i=0;i<n;i++) {
            if(parent[i]==-2) {
                res--;
            }
            else if(parent[i]!=-1){
                set.add(parent[i]);
            }
        }
        System.out.println("rest : "+res);
        int leaf = res-set.size();
        System.out.println(leaf);
    }
    public static int find(int n) {
        while (parent[n]!=-1) {
            n = parent[n];
        }
        return n;
    }
}
