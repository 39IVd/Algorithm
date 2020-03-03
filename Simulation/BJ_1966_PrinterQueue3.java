package Simulation;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1966_PrinterQueue3 {
    static int test_num = 0;
    static int[] targetIndex;
    static Queue<Integer>[] paper;
    static Queue<Integer>[] indexes;
    static int[] res;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        test_num = in.nextInt();
        targetIndex = new int[test_num];
        paper = new LinkedList[test_num];
        indexes = new LinkedList[test_num];
        res = new int[test_num];
        for(int i=0;i<test_num;i++) {
            paper[i] = new LinkedList<>();
            indexes[i] = new LinkedList<>();
            int size = in.nextInt();
            targetIndex[i] = in.nextInt();
            for(int j=0;j<size;j++) {
                int n = in.nextInt();
                paper[i].add(n);
                indexes[i].add(j);
            }

        }
        for(int i=0;i<test_num;i++) {
            int popNum = 0;
            while (!paper[i].isEmpty()) {
                boolean pop = true;
                int cur = paper[i].poll();
                int ind = indexes[i].poll();
                Iterator it = paper[i].iterator();
                while(it.hasNext()) {
                    if(cur<(Integer)it.next()) {
                        paper[i].add(cur);
                        indexes[i].add(ind);
                        pop = false;
                        break;
                    }
                }
                if(pop) {
                    popNum++;
//                    System.out.println(i+"번 : pop index : "+ind+", "+popNum);
                    if(ind== targetIndex[i]) {
                        res[i] = popNum;
                        break;
                    }
                }
            }
        }
        for(int i=0;i<test_num;i++) {
            System.out.println(res[i]);
        }

    }
}
