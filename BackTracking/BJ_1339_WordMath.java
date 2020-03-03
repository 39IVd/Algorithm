package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;



public class BJ_1339_WordMath {
    static int n;
    static String[][] words;
    static Map<Character, Integer> map = new HashMap<>();
    static int maxIndex = 0;
    static int total = 0;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(b.readLine());
        words = new String[n][];
        visited = new int[n];
        for(int i=0;i<n;i++) {
            char[] chars = b.readLine().toCharArray();
            // 각 단어 입력받기
            maxIndex = Math.max(maxIndex, chars.length-1);
            words[i] = new String[chars.length];
            for(int j=0;j<chars.length;j++) {
                words[i][j] = chars[chars.length-j-1]+"";
            }
//             입력받은 단어의 알파벳을 거꾸로 저장
//            words[i] = b.readLine().split("");
        }
        System.out.println(maxIndex);
        for(int i=0;i<n;i++) {
            for(int j=0;j<words[i].length;j++) {
                System.out.print(words[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        backtracking(0, 0, "");
        System.out.println("total "+total);
    }
    public static void backtracking(int index, int count, String str) {
        if(index==maxIndex+1) {
//            가장 긴 알파벳 끝까지 추가한 경우
//            alphaToNum(str);
            initVisited();
            System.out.println(str);
//            System.out.println("max");
            return;
        }
        if(count==n) {
//           각 단어의 특정 index에 있는 알파벳을 모두 순열에 추가한 경우
            initVisited();
//            단어들의 방문 기록 초기화
//            System.out.println("index "+index);

//            System.out.println(str);
            backtracking(index+1, 0, str);
//            다음 index로 넘어가서 다시 backtracking 수행
        }

        for(int i=0;i<n;i++) {

            if(visited[i]!=1) {
                visited[i] = 1;
                if(index>words[i].length-1) {
//                    System.out.println("no alpha");
                    backtracking(index, count+1, str);
//                    visited[i] = 0;
                    continue;
                }
                String alpha = words[i][index];
//                System.out.println("alpha "+alpha);
                if(str.contains(alpha)) {
//                    이미 추가된 알파벳인 경우
                    backtracking(index, count+1, str);
                }
                else {
//                    추가되지 않은 알파벳인 경우
                    backtracking(index, count+1, str+words[i][index]);
                }
                visited[i] = 0;
            }
        }
    }
    public static void initVisited() {
        for(int i=0;i<n;i++) {
            visited[i] = 0;
        }
    }
    public static void alphaToNum(String str) {
        int start = 10 - str.length();
        for(int i=0;i<str.length();i++) {
            map.put(str.charAt(i), start);
            start++;
        }
        for(int i=0;i<n;i++) {
            String number = "";
            for(int j=0;j<words[i].length;j++) {

            }
        }
        int subtotal = Integer.parseInt(str);
        System.out.println("subtotal "+subtotal);
        total = Math.max(total, subtotal);
//            합이 최대인 것을 저장
    }
}

//    중복되지 않는 최대 길이 알파벳 찾기
//        2
//        GCF
//        ACDEB
//        FABDCFC
//
//    => 거꾸로 저장
//        FCG
//        BEDCA
//        CFCDBAF
//
//    => Backtracking으로 FBCEFGDAF / CBFECDGAF .. 로 바꿈
//        ( index = 0부터 최대 length까지 ++
//        FBC FCB BFC BCF .. 비중복 permutation 찾기
//        다음 index .. 반복 )
//    => 3456789 숫자 할당
//    => 각 알파벳을 숫자로 변경 후 최대인 값 찾음
