package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Permutation
// 비중복 순열

public class BJ_15652_NandM_5 {
    static int n, m ;
    static int[] arr;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] s = r.readLine().split(" ");
        n = Integer.parseInt(s[0]); m = Integer.parseInt(s[1]);
        arr = new int[n]; visited = new int[n];
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
        Permutation(0, "");
    }
    public static void Permutation(int count, String str) {
        if(count==m) {
            System.out.println(str);
            return;
        }
        for(int i=0;i<n;i++) {
            if(visited[i]!=1) {
                visited[i] = 1;
                Permutation(count+1, str+arr[i]+" ");
                visited[i] = 0;
            }
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
//        7 1
//        7 8
//        7 9
//        8 1
//        8 7
//        8 9
//        9 1
//        9 7
//        9 8
