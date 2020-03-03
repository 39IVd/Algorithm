package KakaoCodingTest2018;

import java.util.ArrayList;
import java.util.HashSet;

public class Kakao_CandidateKey {
    static String[][] relation =
            {{"100","ryan","music","2"}, {"200","apeach","math","2"}
                    , {"300","tube","computer","3"}, {"400","con","computer","4"}
                    , {"500","muzi","music","3"}, {"600","apeach","music","2"}};
    static ArrayList<HashSet<Integer>> keyList = new ArrayList<>();
    // 모든 가능한 후보키의 list
    static int[] aVisit = new int[relation[0].length];
    // attribute들의 방문 여부 검사
    static int[] iVisit = new int[relation.length];
    // 모든 학생들의 index 방문 여부를 저장 = attribute가 바뀔 때마다 초기화
    public static void main(String[] args) {
        System.out.println(solution(relation));
    }
    public static int solution(String[][] relation) {
        int answer = 0;
        ArrayList iList = new ArrayList();
        // 중복 체크 할 학생들의 index list = 전체로 초기화
        HashSet<Integer> aSet = new HashSet<>();
        // keyList에 넣을 후보키의 집합 = null로 초기화
        for(int i=0;i<relation.length;i++) {
            iList.add(i);
        }

        Check(iList, aSet);
        return answer;
    }
    public static void Check(ArrayList<HashSet<Integer>> iList, HashSet<Integer> aSet) {
        for(int i=0;i<relation[0].length;i++) {
            // 모든 attribute에 대하여 검사
            initIvisit();
            // 중복 검사할 학생들의 index 방문 여부 초기화
            if(aVisit[i]!=1) {
                // 방문하지 않은 attribute이면
                aVisit[i] = 1;
                HashSet<Integer> iSet = new HashSet<>();
                // 중복 검사할 학생들의 index Set
                aSet.add(i);
                // 중복 체크하면서 set에 우선 저장
                boolean dist = true;
                for(int j=0;j<relation.length-1;j++) {
                    // 특정 attribute의 모든 학생에 대하여 중복 검사
                    if(iVisit[j]==0) {
                        // 방문하지 않은
                        iVisit[j] = 1;
                        for(int k=j;k<relation.length;k++) {
                            if(iVisit[k]==0&&relation[j][i].equals(relation[k][i])) {
                                // 방문하지 않은 학생index이고 중복된다면
                                dist = false;
                                // 중복됨
                                iVisit[k] = 1;
                                iSet.add(i); iSet.add(k);
                            }
                        }
                    }
                }
                if(dist) {
                    // 중복 하나도 없으면
                    keyList.add(aSet);
                    // 전체 후보키 list에 저장
                    aSet.clear();
                    // attribute set을 초기화
                }
                else {
                    iList.add(iSet);
                    // 중복되는 index Set을 list에 추가

                }
            }
        }
    }
    public static void initIvisit() {
        for(int i=0;i<relation.length;i++) {
            iVisit[i] = 0;
        }
    }
}
