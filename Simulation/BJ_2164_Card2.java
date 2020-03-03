package Simulation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_2164_Card2 {
    static int n;
    static Queue<Integer> card = new LinkedList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for(int i=1;i<=n;i++) {
            card.add(i);
        }
        while(card.size()>1) {
            card.poll();
            int cur = card.poll();
            card.add(cur);

        }
        System.out.println(card.poll());
    }
}
