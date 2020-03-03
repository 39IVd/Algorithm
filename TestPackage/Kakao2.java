package TestPackage;

import java.util.ArrayList;
import java.util.HashSet;

public class Kakao2 {
    static String[][] relation =
            {{"100","ryan","music","2"}, {"200","apeach","math","2"}
            , {"300","tube","computer","3"}, {"400","con","computer","4"}
            , {"500","muzi","music","3"}, {"600","apeach","music","2"}};
    static int[] visit = new int[relation.length];
    public static void main(String[] args) {
        System.out.println(solution(relation));
    }
    public static int solution(String[][] relation) {
        int answer = 0;
        ArrayList<Integer> key = new ArrayList<>();
        for(int i=0;i<relation[0].length;i++) { // 4
            HashSet<String> set =new HashSet<>();
            ArrayList<Integer> overlap = new ArrayList<>();
            boolean dist = true;
            // 중복 검사
            overlap = examination(i); // 중복된 index들
            if(overlap.isEmpty()) {  // 중복되는게 없음
                answer++;
                visit[i] = 1;
                key.add(i); // key의 index를 저장
            }
            else { // 있음

            }
            for(int j=0;j<relation.length;j++) { // 6
                // 중복 검사

                if(set.contains(relation[j][i])) { // 중복되는게 있음

                    // 중복되는 index들을 저장
                    // 중복되는 index들만 모아서 또다른 key로 실행 - 중복되는거 있는지 확인
                    // 중복됨 - 다른 key로 실행 ++
                    // 중복되는게 없으면 - key.add(현재 key, 그 전 key) 후
                    // visit[] 2개 1로 변경
                    // 전부 중복되면 -
                    dist = false;
                }
                else {
                    set.add(relation[j][i]);
                }
            }
            if(dist) { // 중복되는게 하나도 없으면

            }
        }


        return answer;
    }
    public static void find(int key) {
        for(int i=0;i<relation.length;i++) { // 6 모든 key에 대하여
            // 중복 검사 (다른 함수 이용) - 중복이 하나도 없는 key들은 visit[] = 1
            // 중복되는 항목이 있을 경우 index들을
            // ArrayList<Arraylist> or Arraylist<arr[]>에 저장
            // ex) computer [2 3 4] music [0 5]
            // visit = 0 인 모든 key들 중 list.get(i)에 있는 모든 index가 구별되는지 검사
            // 전부 구별됨 -



        }
    }
    public static ArrayList<Integer> examination(int c) {
        // 어떤 key값의 어떤 element들 중에서 검사하는지
        ArrayList<Integer> overlep = new ArrayList<>();
        for(int i=0;i<relation.length-1;i++) {
            for(int j=i;j<relation.length;j++) {
                if(relation[i][c].equals(relation[j][c])) {
                    // 중복됨
                    overlep.add(i);
                    overlep.add(j);
                }
            }
        }
        return overlep;
    }
}
