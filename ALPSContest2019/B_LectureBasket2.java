package ALPSContest2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_LectureBasket2 {
    static int n, m;
    static int[] L, cp_L;
    static ArrayList<Integer>[][] stu;
    static ArrayList<Integer>[] clear;
    static int stoi(String s) {return Integer.parseInt(s);}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = stoi(st.nextToken()); m = stoi(st.nextToken());
        L = new int[m+1]; cp_L = new int[m+1];
        stu = new ArrayList[n][n]; clear = new ArrayList[n];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=m;i++) {
            L[i] = stoi(st.nextToken());
            cp_L[i] = L[i];
        }
        for(int i=0;i<n;i++) {
            clear[i] = new ArrayList<>();
        }
        for(int j=0;j<2;j++) {
            for(int i=0;i<n;i++) {
                stu[i][j] = new ArrayList();
                st = new StringTokenizer(br.readLine());
                while(true) {
                    int val = stoi(st.nextToken());
                    if (val == -1) {
                        break;
                    }
                    stu[i][j].add(val);
                    L[val]--;
                }
            }
//            String res2 ="\n";
//            res2 +=(j+1)+"차 후 L[i] : ";
            for(int i=1;i<=m;i++) {
//                System.out.println(i+": "+L[i]);
                if(L[i]!=cp_L[i]) { // 값이 바뀐 과목들만.
                    if(L[i]>-1) {
                         // i번쨰 과목을 선택한 학생들은 clear에 add.
                        for(int k=0;k<n;k++) { // 전체 stu 중에서
                            if(stu[k][j].contains(i)) {
                                clear[k].add(i);
                            }
                        }
                    }
//                    else {
//                        L[i] = cp_L[i];
//                    }
                }
//                res2+=L[i]+" ";
                cp_L[i] = L[i];
            }
//            System.out.println(res2);
        }
        String res = "";
        for(int i=0;i<n;i++) {
            if(clear[i].isEmpty()) {
                res+="망했어요\n";
            }
            else {
                for(int k : clear[i]) {
                    res+=k+" ";
                }
                res+="\n";
            }
        }
        System.out.println(res);
//        for(int j=0;j<2;j++) {
//            System.out.println((j+1)+"차");
//            for(int i=0;i<n;i++) {
//                for(int k : stu[i][j]) {
//                    System.out.print(k+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }
    }
}
