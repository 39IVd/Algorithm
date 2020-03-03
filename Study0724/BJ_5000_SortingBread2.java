package Study0724;

import java.util.*;

public class BJ_5000_SortingBread2 {
    static String[] A, B;
    static int N;
    static boolean pos = false;
    static ArrayList<String[]> list = new ArrayList<>();
    static Stack<String[]> stack = new Stack<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        scan.nextLine();
        A = scan.nextLine().split(" ");
        B = scan.nextLine().split(" ");
        list.add(A);
        stack.add(A);
        Roll();

        if(pos) {
            System.out.println("Possible");
        }
        else {
            System.out.println("Impossible");
        }
    }
    public static void Roll() {
        while(!stack.isEmpty()) {
            String[] roll = stack.pop();

            if(isSame(B, roll)) {
                pos = true;
                break;
            }
            String[] temp = new String[N];
            for(int i=0;i<=N-3;i++) {
                for(int j=0;j<N;j++) {
                    temp[j] = roll[j];
                }
                temp[i + 2] = roll[i + 1];
                temp[i + 1] = roll[i];
                temp[i] = roll[i + 2];

                if(!isInList(temp)) {
                    stack.push(temp);
                    list.add(temp);
                    for (int j = 0; j < N; j++) {
                        System.out.print(temp[j]);
                    }
                    System.out.println();
                }
            }
        }
    }
//    public static void Roll(String[] roll) {
//        if(isSame(B, roll)) {
//            pos = true;
//        }
//        else {
//            String[] temp = new String[N];
//            for(int i=0;i<=N-3;i++) {
//                for(int j=0;j<N;j++) {
//                    temp[j] = roll[j];
//                }
//                temp[i + 2] = roll[i + 1];
//                temp[i + 1] = roll[i];
//                temp[i] = roll[i + 2];
//
//
//                if(!isInList(temp)) {
//                    for (int j = 0; j < N; j++) {
//                        System.out.print(temp[j]);
//                    }
//                    System.out.println();
//                    list.add(temp);
//                    Roll(temp);
//                }
//            }
//        }
//    }
    public static boolean isInList(String[] temp) {
//        System.out.println(list.size());
        for(int i=0;i<list.size();i++) {
            boolean same = true;
            String[] comp = list.get(i);
            for(int j=0;j<N;j++) {
                if(!temp[j].equals(comp[j])) {
                    same = false;
                    break;
                }
            }
            if(same) {
                return true;
            }
        }
        return false;
    }
    public static boolean isSame(String[] dest, String[] temp) {
        boolean same = true;
        for(int i =0;i<N;i++) {
            if(!temp[i].equals(dest[i])) {
                same = false;
            }
        }
        return same;
    }
}
