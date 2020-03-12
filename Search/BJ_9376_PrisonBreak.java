//package Search;
//
//import java.util.*;
//
////class point_PB {
////    int y, x, cnt;
////    point_PB(int y, int x, int cnt) {
////        this.y = y; this.x = x; this.cnt = cnt;
////    }
////}
//
//public class BJ_9376_PrisonBreak {
//    static Scanner in = new Scanner(System.in);
//    static int t;
//    static int n, m;
//    static StringBuilder sb = new StringBuilder();
//    static String[][] map = new String[101][101];
//    static int[][] visited = new int[101][101];
//    static int wallCnt;
//    static int[] dy = {-1, 0, 1, 0};
//    static int[] dx = {0, 1, 0, -1};
//    static ArrayList<point_PB> border;
//    public static void main(String[] args) {
//        t = in.nextInt();
//        for(int c=0;c<t;c++) {
//            n = in.nextInt(); m = in.nextInt();
//            in.nextLine();
//            border = new ArrayList<>();
//            System.out.println("\n"+(c+1)+"th");
//            for(int i=0;i<n;i++) {
//                map[i] = in.nextLine().split("");
//                Arrays.fill(visited[i],0);
//                for(int j=0;j<m;j++) {
//                    if(i==0||i==n-1||j==0||j==m-1) {
//                        if(map[i][j].equals("#")) {
//                            border.add(new point_PB(i, j, 1));
//                        }
//                        else if(map[i][j].equals(".")) {
//                            border.add(new point_PB(i, j, 0));
//                        }
//                    }
//                }
//            }
//            bfs();
//            sb.append(wallCnt+"\n");
//        }
//        System.out.println(sb);
//    }
//    public static void bfs() {
//        wallCnt = Integer.MAX_VALUE;
//        Queue<point_PB> q = new LinkedList<>();
//        for(int c=0;c<border.size();c++) {
//            int found = 0;
////            int cnt = 0;
//            q.clear(); initVisit();
//            q.add(border.get(c));
//            while (!q.isEmpty()) {
//                point_PB curr = q.poll();
//                System.out.println(curr.y+","+curr.x+" : "+curr.cnt);
//                visited[curr.y][curr.x] =1;
//                if(map[curr.y][curr.x].equals("$")) found++;
//                if(found==2) {
//                    wallCnt = Math.min(wallCnt, curr.cnt);
//                }
//                for(int i=0;i<4;i++) {
//                    int ny = curr.y + dy[i];
//                    int nx = curr.x + dx[i];
//                    if(ny>=0&&ny<n&&nx>=0&&nx<m) {
//                        if(visited[ny][nx]==0) {
//                            if(map[ny][nx].equals(".")) {
//                                q.add(new point_PB(ny, nx, curr.cnt));
//                            }
//                            else if(map[ny][nx].equals("#")) {
//                                q.add(new point_PB(ny, nx, curr.cnt+1));
//                            }
//                            else if(map[ny][nx].equals("$")) {
//                                q.add(new point_PB(ny, nx, curr.cnt));
//                            }
//                        }
//                    }
//                }
//            }
//
//        }
//    }
//    public static void initVisit() {
//        for(int i=0;i<n;i++) {
//            for(int j=0;j<m;j++) {
//                visited[i][j] = 0;
//            }
//        }
//    }
//}
