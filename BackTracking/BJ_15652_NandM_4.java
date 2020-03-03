package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 비내림차순 순열
// A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK

public class BJ_15652_NandM_4 {
    static int n, m ;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] s = r.readLine().split(" ");
        n = Integer.parseInt(s[0]); m = Integer.parseInt(s[1]);
        nonDescendingPermutation(0, 1, "");
    }
    public static void nonDescendingPermutation(int count, int num, String str) {
        if(count==m) {
            System.out.println(str);
            return;
        }
        for(int i=num;i<=n;i++) {
            nonDescendingPermutation(count+1, i, str+i+" ");
        }
    }
}

//ex)
//input : 4 2
//output :
//        1 1
//        1 2
//        1 3
//        1 4
//        2 2
//        2 3
//        2 4
//        3 3
//        3 4
//        4 4