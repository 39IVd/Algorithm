package Simulation;

import java.util.Scanner;

class Group {
    String name;
    int pos;
    public Group(String name, int pos) {
        this.name =  name;
        this.pos = pos;
    } // 0 right 1 left
}

public class BJ_3048_Ants {
    static int n1, n2;
    static String[] G1, G2;
    static int t;
    static Group[] group;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n1 = scan.nextInt(); n2 = scan.nextInt();
        scan.nextLine();
        G1 = new String[n1]; G2 = new String[n2];
        group = new Group[n1+n2];
        G1 = scan.nextLine().split("");
        G2 = scan.nextLine().split("");
        t = scan.nextInt();
        for(int i=0;i<n1;i++) {
            group[i] = new Group(G1[n1-1-i], 0);
        }
        for (int i=n1;i<n1+n2;i++) {
            group[i] = new Group(G2[i-n1], 1);
        }
//        for(int i=0;i<n1+n2; i++) {
//            System.out.print(group[i].name+ group[i].pos);
//        }
//        System.out.println();
          find();
    }
    public static void find() {
        int time = 0;
        while(time<t) {
            for(int i=0;i<n1+n2-1;i++) {
                if (group[i].pos==0 && group[i + 1].pos==1) {
                    Group tmp = new Group(group[i].name, group[i].pos);
                    group[i].name = group[i+1].name;
                    group[i].pos = group[i+1].pos;
                    group[i+1].name = tmp.name;
                    group[i+1].pos = tmp.pos;
                    i = i+1;
                }
            }
            time++;
//            System.out.print(time+": ");
//            for(int i=0;i<n1+n2; i++) {
//                System.out.print(group[i].name);
//            }
//            System.out.println();
        }
        for(int i=0;i<n1+n2; i++) {
            System.out.print(group[i].name);
        }
    }
}
