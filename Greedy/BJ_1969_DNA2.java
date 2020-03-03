package Greedy;

import java.util.Scanner;

public class BJ_1969_DNA2 {
    static Scanner in = new Scanner(System.in);
    static int n, m;
    static char[][] dna = new char[1000][50];
    static int[][] alpha = new int[50][4];
    public static void main(String[] args) {
        n = in.nextInt(); m = in.nextInt();
        in.nextLine();
        for(int i=0;i<n;i++) {
            dna[i] = in.nextLine().toCharArray();
        }
        for(int i=0;i<m;i++) {
            alpha[i] = new int[4];
            for(int j=0;j<n;j++) {
                switch (dna[j][i]) {
                    case 'A':
                        alpha[i][0]++;
                        break;
                    case 'C':
                        alpha[i][1]++;
                        break;
                    case 'G':
                        alpha[i][2]++;
                        break;
                    case 'T':
                        alpha[i][3]++;
                        break;
                }
            }
        }
        String s = "";
        int total = 0;
        for(int i=0;i<m;i++) {
            int max = 0; int maxIndex = -1;
            for(int j=0;j<4;j++) {
                if(alpha[i][j]>max) {
                    maxIndex = j;
                    max = alpha[i][j];
                }
            }
            total+= n-max;
            switch (maxIndex) {
                case 0:
                    s+='A';
                    break;
                case 1:
                    s+='C';
                    break;
                case 2:
                    s+='G';
                    break;
                case 3:
                    s+='T';
                    break;
            }

        }
        System.out.println(s);
        System.out.println(total);
    }
}
