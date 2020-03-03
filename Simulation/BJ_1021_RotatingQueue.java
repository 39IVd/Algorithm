package Simulation;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BJ_1021_RotatingQueue {
    static int n, m;
    static int[] pull = new int[50];
    static List<Integer> list = new LinkedList<>();
    static int total = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        for (int i = 0; i < m; i++) {
            pull[i] = in.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        for (int i = 0; i < m; i++) {
            while (true) {
                if (list.indexOf(pull[i]) == 0) {
                    list.remove(0);
                    break;

                }
                else if (list.indexOf(pull[i]) < list.size() - list.indexOf(pull[i])) {
//                왼쪽 이동
                    System.out.println("left");
                    int cnt = list.indexOf(pull[i]);
                    total += cnt;
                    for (int j = 0; j < cnt; j++) {
                        int tmp = list.get(0);
                        list.remove(0);
                        list.add(tmp);
                    }

                }
                else {
//                오른쪽 이동
                    System.out.println("right");
                    int cnt = list.size() - list.indexOf(pull[i]);
                    total += cnt;
                    for (int j = 0; j < cnt; j++) {
                        int tmp = list.get(list.size() - 1);
                        list.remove(list.size() - 1);
                        list.add(0, tmp);
                    }

                }
                for (int j = 0; j < list.size(); j++) {
                    System.out.print(list.get(j) + " ");
                }
                System.out.println("\n");
            }
        }
        System.out.println(total);
    }
}
