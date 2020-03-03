package KakaoCodingTest2018;

import java.util.ArrayList;
import java.util.HashSet;

public class Kakao_CandidateKey2 {
    static String[][] relation =
            {{"100","ryan","music","2"}, {"200","apeach","math","2"}
                    , {"300","tube","computer","3"}, {"400","con","computer","4"}
                    , {"500","muzi","music","3"}, {"600","apeach","music","2"}};
    static int[] visit = new int[relation[0].length];
//    static ArrayList<HashSet<Integer>> list = new ArrayList<>();
    static ArrayList<int[]> list = new ArrayList<>();

    static HashSet<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        System.out.println(solution(relation));
    }
    public static int solution(String[][] relation) {
        int answer = 0;
//        for(int i=1;i<=relation[i].length;i++) {
//            dfs(0, i, set);
//        }
        int[] arr = new int[2];
        dfs(0, 2, arr);

//        dfs(0, 2, set);

        for(int i=0;i<list.size();i++) {
            int[] array = list.get(i);
            for(int j=0;j<list.get(i).length;j++) {
                System.out.print(list.get(i)[j]+" ");
            }
            System.out.println();
        }
        return answer;
    }
    // dfs를 이용하여 attribute의 모든 부분 집합 생성
    // ex) attribute index = {0 1 2 3}
    // 4C4를 이용해서
    // ArrayList<HashSet> list = {[0][1][2][3][01][02][03][12][13][23][012][013][123][0123]}
    // set에 add 하고 최종적으로 arraylist에 add
    public static void dfs(int cnt, int max, int[] arr) {
        if(cnt==max) {
            int[] arr2 = new int[max];
            for(int i=0;i<max;i++) {
                arr[i] = arr[i];
            }
            list.add(arr2);
            arr[cnt-1] = -1;
//            for(int i=0;i<relation[0].length;i++) {
//                visit[i] = 0;
//            }
        }
        else {
            for(int i=0;i<relation[0].length;i++) {
                if(visit[i]!=1) {
                    arr[cnt] = i;
                    visit[i] = 1;
                    dfs(cnt+1, max, arr);
                    visit[i] = 0;
                }
            }
        }
    }
//    public static void dfs(int cnt, int max, HashSet<Integer> set) {
//        if(set.size()==max) {
//            HashSet<Integer> set2 = new HashSet<>();
//            set2.addAll(set);
//            list.add(set2);
//            set.clear();
////            for(int i=0;i<relation[0].length;i++) {
////                visit[i] = 0;
////            }
//        }
//        else {
//            for(int i=0;i<relation[0].length;i++) {
//                if(visit[i]!=1) {
//                    set.add(i);
//                    visit[i] = 1;
//                    dfs(cnt+1, max, set);
//                    visit[i] = 0;
//                }
//            }
//        }
//    }
}
