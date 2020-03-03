package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Permutation
// 중복순열

public class BJ_15652_NandM_7 {
    static int n, m ;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] s = r.readLine().split(" ");
        n = Integer.parseInt(s[0]); m = Integer.parseInt(s[1]);
        arr = new int[n];
        s = r.readLine().split(" ");
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        for(int i=0;i<n-1;i++) {
            // 배열 정렬
            for(int j=i+1;j<n;j++) {
                if(arr[i]>arr[j]) {
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
        multiPermutation(0, "");
    }
    public static void multiPermutation(int count, String str) {
        if(count==m) {
            System.out.println(str);
            return;
        }
        for(int i=0;i<n;i++) {
            multiPermutation(count+1, str+arr[i]+" ");
        }
    }
}

//ex)
//input :
//        4 2
//        9 8 7 1
//output :
//        1 1
//        1 7
//        1 8
//        1 9
//        7 1
//        7 7
//        7 8
//        7 9
//        8 1
//        8 7
//        8 8
//        8 9
//        9 1
//        9 7
//        9 8
//        9 9