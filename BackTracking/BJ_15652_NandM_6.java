package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Combination
// 조합 = 오름차순 순열

public class BJ_15652_NandM_6 {
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
        Combination(0, -1, "");
//        Combination2(0, 0, "");
    }
    public static void Combination(int count, int num, String str) {
        if(count==m) {
            System.out.println(str);
            return;
        }
        for(int i=num+1;i<n;i++) {
            Combination(count+1, i, str+arr[i]+" ");
        }
    }
    public static void Combination2(int count, int num, String str) {
        if(count==m) {
            System.out.println(str);
            return;
        }
        if(num<n) {
            Combination2(count+1, num+1, str+arr[num]+" ");
            Combination2(count, num+1, str);
        }
    }
}

//ex)
//input :
//        4 2
//        9 8 7 1
//output :
//        1 7
//        1 8
//        1 9
//        7 8
//        7 9
//        8 9
