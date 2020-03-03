package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Permutation
// 비중복 순열 => 방문 여부 체크

public class BJ_15649_NandM_1 {
    static int n, m;
    static int[] visited;
    public static void main(String[] args) throws IOException {
//        Scanner in = new Scanner(System.in);
//        n = in.nextInt(); m = in.nextInt();
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] s = r.readLine().split(" ");
        n = Integer.parseInt(s[0]); m = Integer.parseInt(s[1]);
        visited = new int[n+1];
        permutation(0, "");
    }
    public static void permutation(int count, String str) {
        if(count==m) {
            System.out.println(str);
            return;
        }
        for(int i=1;i<=n;i++) {
            if(visited[i]!=1) {
                visited[i] = 1;
                permutation(count+1, str+i+" ");
                visited[i] = 0;
            }
        }
    }
}

//ex)
//input : 4 2
//output :
//        1 2
//        1 3
//        1 4
//        2 1
//        2 3
//        2 4
//        3 1
//        3 2
//        3 4
//        4 1
//        4 2
//        4 3
