package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BJ_1339_WordMath3 {
    static int n;
    static String[] words;
    static Map<Character, Integer> map = new HashMap<>();
    static int maxIndex = 0;
    static int total = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(b.readLine());
        words = new String[n];
        for(int i=0;i<n;i++) {
            String s = b.readLine();
            words[i] = "";
            for(int j=0;j<s.length();j++) {
                words[i] += s.charAt(s.length()-1-j);
            }
            maxIndex = Math.max(maxIndex, words[i].length()-1);
        }
//        for(int i=0;i<n;i++) {
//            System.out.println(words[i]);
//        }
        cal();
//        System.out.println(map);
        alphaToNum(map);

        System.out.println(total);
    }
    public static void cal() {
//        1의 자리부터 탐색하면서 map에 저장
//        중복되는 알파벳인 경우 높은 자리에 위치한 알파벳을 나중에 put
        int number = 0;
        for(int i=0;i<=maxIndex;i++) {
            for(int j=0;j<n;j++) {
                if(i<words[j].length()) {
                    char alpha = words[j].charAt(i);
                    map.put(alpha, number);
                    number++;
                }
            }
        }
    }
    public static void alphaToNum(Map<Character, Integer> map) {
        List keySetList = new ArrayList<Character>(map.keySet());
        // List 내림차순 정렬 //
//        알파벳에 할당된 숫자가 높은순으로 정렬
        Collections.sort(keySetList, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });
//        알파벳에 할당된 숫자가 높은 순으로 9부터 다시 저장
        int count = 9;
        for(Object key : keySetList) {
            map.replace((Character)key, count--);
        }
//        System.out.println(map);

        for(int i=0;i<n;i++) {
            String s = "";
            for(int j=words[i].length()-1;j>=0;j--) {
                s += map.get(words[i].charAt(j));
            }
            total += Integer.parseInt(s);
        }
    }
}
