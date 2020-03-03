package Study0807;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BJ_2573_Iceberg2 {
    static int N, M;
    static int[][] matrix;
    static int[][] melt;
    static int[][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        matrix = new int[N][M];
        visit = new int[N][M];
        melt = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        while(true) {
            int cnt = 0;
            for(int i=0;i<N;i++) {
                for(int j=0;j<M;j++) {
                    if(matrix[i][j]!=0 && visit[i][j]==0) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            if(cnt==0) {
                System.out.println(0);
                break;
            }
            else if(cnt>=2) {
                System.out.println(year);
                break;
            }
            Sinking();
            year++;
        }
    }
    public static void dfs(int x, int y) {
        visit[x][y] = 1;
        for(int k=0;k<4;k++) {
            int px = dx[k]+x;
            int py = dy[k]+y;
            if(0 <= px && px < N && 0 <= py && py < M) {
                if(matrix[px][py]==0) {
                    melt[px][py]++;
                }
                if(matrix[px][py]!=0 && visit[px][py]==0) {
                    dfs(px, py);
                }
            }
        }
    }
    public static void Sinking() {
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                matrix[i][j] -= melt[i][j];
                if(matrix[i][j]<0) {
                    matrix[i][j]=0;
                }
                visit[i][j] = 0;
                melt[i][j] = 0;
            }
        }
    }
    public static boolean inRange(int x, int y) {
        if(x>=0&&x<N&&y>=0&&y<M) {
            return true;
        }
        else {
            return false;
        }
    }
}
