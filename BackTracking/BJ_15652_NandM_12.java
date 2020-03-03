package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// 중복되는 배열에서 비내림차순 순열 찾기
// 중복 출력 제외

public class BJ_15652_NandM_12 {
    static int n, m ;
    static int[] arr;
    static int[] visited;
    static Set<String> set = new HashSet<>();
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
        combination(0, 0, "");
    }
    public static void combination(int count, int num, String str) {
        if(count==m) {
            if(!set.contains(str)) {
                set.add(str);
                System.out.println(str);
            }
            return;
        }
        for(int i=num;i<n;i++) {
            combination(count+1, i,str+arr[i]+" ");
        }
    }
}

//ex)
//input :
//        4 2
//        9 7 9 1
//output :
//        1 1
//        1 7
//        1 9
//        7 7
//        7 9
//        9 9