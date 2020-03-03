package Study0724;

import java.util.Scanner;

public class BJ_5000_SortingBread {
    static String[] A, B;
    static int N;
    static boolean pos = false;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        scan.nextLine();
        A = scan.nextLine().split(" ");
        B = scan.nextLine().split(" ");

        if(!isSame(B, A)) {
            String[] temp = new String[N];
            for (int i = 0; i < N; i++) {
                temp[i] = A[i];
            }
            for (int i = 0; i <= N - 3; i++) {
                temp[i + 2] = A[i + 1];
                temp[i + 1] = A[i];
                temp[i] = A[i + 2];
                for (int j = 0; j < N; j++) {
                    System.out.print(temp[j]);
                }
                System.out.println();
                Roll(temp);
            }
        }
        else {
            pos = true;
        }

        if(pos) {
            System.out.println("Possible");
        }
        else {
            System.out.println("Impossible");
        }

    }
    public static void Roll(String[] roll) {
        if(isSame(B, roll)) {
            pos = true;
        }
        else if(!isSame(A, roll)) {
            String[] temp = new String[N];
            for(int i=0;i<N;i++) {
                temp[i] = roll[i];
            }
            for(int i=0;i<=N-3;i++) {
                temp[i + 2] = roll[i + 1];
                temp[i + 1] = roll[i];
                temp[i] = roll[i + 2];
                for (int j = 0; j < N; j++) {
                    System.out.print(temp[j]);
                }
                System.out.println();
                Roll(temp);
            }
        }

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
