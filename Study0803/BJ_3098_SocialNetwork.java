package Study0803;

import java.util.Scanner;

public class BJ_3098_SocialNetwork {
    static int N, M;
    static int[][] graph;
    static int[][] visit;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt(); M = in.nextInt();
        in.nextLine();
        graph = new int[N+1][N+1];
        visit = new int[N+1][N+1];
        for(int i=0;i<M;i++) {
            String[] arr = new String[2];
            arr = in.nextLine().split(" ");
            graph[Integer.parseInt(arr[0])][Integer.parseInt(arr[0])] = 1;
            graph[Integer.parseInt(arr[1])][Integer.parseInt(arr[1])] = 1;
            graph[Integer.parseInt(arr[0])][Integer.parseInt(arr[1])] = 1;
            graph[Integer.parseInt(arr[1])][Integer.parseInt(arr[0])] = 1;
        }
//        for(int i=1;i<=N;i++) {
//            for(int j=1;j<=N;j++) {
//                System.out.print(graph[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();
        find();
    }
    public static void find() {
        int day = 0;
        boolean notAllFriends = true;
        int[] rel = new int[N*(N-1)/2];
        while(notAllFriends) {
            notAllFriends = false;
            for(int i=1;i<=N;i++) {
                for(int j=1;j<=N;j++) {
                    if(graph[i][j]==0) {
                        notAllFriends = true;
                    }
                }
            }
            if(!notAllFriends) {
                break;
            }
            day++;
            rel[day] = 0;
            for(int i=1;i<=N;i++) {
                for(int j=1;j<=N;j++) {
                    if(i!=j&&graph[i][j]==1&& visit[i][j]!=1) {
                        for(int k=1;k<=N;k++) {
                            if(graph[i][k]==0&&graph[j][k]==1&&visit[j][k]!=1) {
                                graph[i][k] = 1;
                                visit[i][k] = 1;
                                rel[day]++;
                            }
                        }
                    }
                }
            }
            for(int i=1;i<=N;i++) {
                for(int j=1;j<=N;j++) {
                    visit[i][j] = 0;
                }
            }
//
//            for(int i=1;i<=N;i++) {
//                for(int j=1;j<=N;j++) {
//                    System.out.print(graph[i][j]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();
        }
        System.out.println(day);
        for(int i=1;i<=day;i++) {
            System.out.println(rel[i]/2);
        }
    }
}
