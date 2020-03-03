package Simulation;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1966_PrinterQueue {
    static int test_num = 0;
    static int[] target;
    static Queue<Integer>[] paper;
    static int[] res;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        test_num = in.nextInt();
        target = new int[test_num];
        paper = new LinkedList[test_num];
        res = new int[test_num];
        for(int i=0;i<test_num;i++) {
            paper[i] = new LinkedList<>();
            int size = in.nextInt();
            int t = in.nextInt();
            for(int j=0;j<size;j++) {
                int n = in.nextInt();
                paper[i].add(n);
                if(t==j) {
                    target[i] = n;
                }
            }

        }
        for(int i=0;i<test_num;i++) {
            int popNum = 0;
            while (!paper[i].isEmpty()) {
                boolean pop = true;
                int cur = paper[i].poll();
                Iterator it = paper[i].iterator();
                while(it.hasNext()) {
                    if(cur<(Integer)it.next()) {
                        paper[i].add(cur);
                        pop = false;
                        break;
                    }
                }
                if(pop) {
                    popNum++;
                    if(cur==target[i]) {
                        res[i] = popNum;
                        break;
                    }
                    System.out.println(i+"번 : pop "+cur+", "+popNum);
                }
            }
        }
        for(int i=0;i<test_num;i++) {
//            for(int j=0;j<paper[i].size();j++) {
//                System.out.print(paper[i].get(j)+" ");
//            }
//            System.out.println();
            System.out.println(target[i]);
            System.out.println(res[i]);
        }

    }
}
