package Study0818;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BJ_16722_GyalHap {
    static int[][] matrix = new int[10][4];
    static int n;
    static List<HashSet<Integer>> list = new LinkedList<>();
    static List<HashSet<Integer>> clist = new LinkedList<>(); // 합 외친 리스트
    static int score = 0; static boolean g = false;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for(int i=1;i<=9;i++) {
            String[] st = in.nextLine().split(" ");
            switch (st[0]) {
                case "CIRCLE":
                    matrix[i][0] = 0;
                    break;
                case "SQUARE":
                    matrix[i][0] = 1;
                    break;
                case "TRIANGLE":
                    matrix[i][0] = 2;
                    break;
            }
            switch (st[1]) {
                case "YELLOW":
                    matrix[i][1] = 0;
                    break;
                case "RED":
                    matrix[i][1] = 1;
                    break;
                case "BLUE":
                    matrix[i][1] = 2;
                    break;
            }
            switch (st[2]) {
                case "GRAY":
                    matrix[i][2] = 0;
                    break;
                case "BLACK":
                    matrix[i][2] = 1;
                    break;
                case "WHITE":
                    matrix[i][2] = 2;
                    break;
            }
        }
        for(int i=1;i<=7;i++) {
            for(int j=2;j<=8;j++) {
                for(int k=3;k<=9;k++) {
                    if(i!=j&&j!=k&&i!=k) {
                        if(Cal(i, j, k)) {
                            HashSet<Integer> set = new HashSet<>();
                            set.add(i); set.add(j); set.add(k);
                            if(!list.contains(set)) {
//                                System.out.println(set);
                                list.add(set);
                            }
                        }
                    }
                }
            }
        }
        n = in.nextInt(); in.nextLine();
        for(int i=0;i<n;i++) {
            String[] st = in.nextLine().split(" ");
            if(st[0].equals("H")) {
                HashSet<Integer> cset = new HashSet<>();
                cset.add(Integer.parseInt(st[1]));
                cset.add(Integer.parseInt(st[2]));
                cset.add(Integer.parseInt(st[3]));
                if(!clist.contains(cset)&&list.contains(cset)) {
                    clist.add(cset);
//                    System.out.println("h:"+(i+1)+cset);
                    list.remove(cset);
                    score += 1;
                }
                else {
//                    System.out.println("incorrect");
                    score -= 1;
                }
            }
            else {
                if(list.isEmpty()&&!g) {
//                    System.out.println("g O");
                    g = true;
                    score += 3;
                }
                else {
//                    System.out.println("g X");
                    score -= 1;
                }
            }
        }
        System.out.println(score);
    }
    public static boolean Cal(int i, int j, int k) { // 3가지 비교
        boolean match_c = false, match_s = false, match_b = false;
        if(matrix[i][0]==matrix[j][0]&&matrix[j][0]==matrix[k][0]) {
            match_c = true;
        }
        else if(matrix[i][0]!=matrix[j][0]&&matrix[j][0]!=matrix[k][0]
                &&matrix[i][0]!=matrix[k][0]) {
            match_c = true;
        }
        if(matrix[i][1]==matrix[j][1]&&matrix[j][1]==matrix[k][1]) {
            match_s = true;
        }
        else if(matrix[i][1]!=matrix[j][1]&&matrix[j][1]!=matrix[k][1]
                &&matrix[i][1]!=matrix[k][1]) {
            match_s = true;
        }
        if(matrix[i][2]==matrix[j][2]&&matrix[j][2]==matrix[k][2]) {
            match_b = true;
        }
        else if(matrix[i][2]!=matrix[j][2]&&matrix[j][2]!=matrix[k][2]
                &&matrix[i][2]!=matrix[k][2]) {
            match_b = true;
        }
        if(match_c&&match_s&&match_b) {
            return true;
        }
        else {
            return false;
        }
    }
}
