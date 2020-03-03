package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 중복순열

public class BJ_15651_NandM_3 {
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] s = r.readLine().split(" ");
        n = Integer.parseInt(s[0]); m = Integer.parseInt(s[1]);
        multiPermutation(0, "");
    }
    public static void multiPermutation(int count, String str) {
        if(count==m) {
            System.out.println(str);
            return;
        }
        for(int i=1;i<=n;i++) {
            multiPermutation(count+1, str+i+" ");
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
//        2 1
//        2 2
//        2 3
//        2 4
//        3 1
//        3 2
//        3 3
//        3 4
//        4 1
//        4 2
//        4 3
//        4 4