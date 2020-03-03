package BackTracking;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BJ_1653_BalanceScale {
    static int n;
    static List<Integer> allSinker = new LinkedList<>();
    static int k;
    static int[] visited;
    static int ltotal = 0;
    static List<Integer> rightSinker = new LinkedList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        visited = new int[n];
        for(int i=0;i<n;i++) {
            allSinker.add(in.nextInt());
        }
        k = in.nextInt();

        for(int select=1;select<n;select++) {
//            왼쪽 저울 : n개에서 select개 선택 순열
            ldfs(select, 0, new LinkedList<Integer>());
        }
    }
    public static void ldfs(int select, int count, List<Integer> scale) {
        if(select==count) {
            for(int i=0;i<scale.size();i++) {
                System.out.print(scale.get(i)+" ");
            }
            System.out.println();
            int[] position = new int[5];
            Placing(0, 0, scale, position);
//            System.out.println("ltotal : "+ltotal);
            return;
        }
        for(int i=0;i<allSinker.size();i++) {
            if(visited[i]!=1) {
                visited[i] = 1;
                List<Integer> newScale = new LinkedList<>();
                newScale.addAll(scale);
                newScale.add(allSinker.get(i));
                ldfs(select, count+1, newScale);
                visited[i] = 0;
            }
        }
    }
    public static void Placing(int count, int num, List<Integer> scale, int[] position) {
        if(count==scale.size()) {
//            합 계산
            for(int i=0;i<5;i++) {
                if(position[i]!=0) {
                    ltotal += (5-i)*position[i];
//                    System.out.println("pos : "+i+", value : "+position[i]);
                }
            }
            System.out.println("ltotal : "+ltotal);
            allSinker.removeAll(scale);
            rightSinker.addAll(allSinker);
            rdfs(new LinkedList<>(), 0);
            ltotal = 0;
            return;
        }
        for(int i=num;i<5;i++) {
            position[i] = scale.get(count);
//            System.out.println("pos : "+i+", value : "+position[i]);
            Placing(count+1, i+1, scale, position);
            position[i] = 0;
        }
    }
    public static void rdfs(List<Integer> rightScale, int rtotal) {
        if(rtotal==ltotal) {
//            출력
            return;
        }
    }
}
