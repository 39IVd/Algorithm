package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Combination
// 조합 (N개 중에서 중복 없이 M개 뽑기)
// 오름차순 Permutation과 같음

public class BJ_15650_NandM_2 {
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] s = r.readLine().split(" ");
        n = Integer.parseInt(s[0]); m = Integer.parseInt(s[1]);
        combination(0, 0, "");
//        combination2(0, 1, "");
    }
    public static void combination(int count, int num, String str) {
        if(count==m) {
            System.out.println(str);
            return;
        }
        for(int i=num+1;i<=n;i++) {
            combination(count+1, i, str+i+" ");
        }
    }
    public static void combination2(int count, int num, String str) {
        if(count==m) {
            System.out.println(str);
            return;
        }
        if(num<=n) {
            combination2(count+1, num+1, str+num+" ");
            combination2(count, num+1, str);
        }
    }
}
//ex)
//input : 4 2
//output :
//        1 2
//        1 3
//        1 4
//        2 3
//        2 4
//        3 4
