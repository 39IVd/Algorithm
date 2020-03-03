package Study0807;

import java.util.HashSet;
import java.util.Scanner;

public class BJ_1062_Teaching2 {
    static int N, K;
    static HashSet<Character> candidate = new HashSet<>();
    static int max = 0, precount = 0, w = 0;
    static String[] wordSet;
    static char[] charSet;
    static boolean[] visit;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt(); K = in.nextInt();
        in.nextLine();
        wordSet = new String[N];
        for(int i=0;i<N;i++) {
            String str = in.nextLine();
            str = str.replaceAll("[antic]", "");
            if(str.length()==0) {
                precount++;
            }
            else {
                wordSet[w++] = str;
                for(int j=0;j<str.length();j++) {
                    candidate.add(str.charAt(j));
                }
            }
        }
        if(K<5) precount = max = 0;
        else {
            K-=5;
            charSet = new char[candidate.size()];
            visit = new boolean[candidate.size()];
            int i=0;
            for(char ch : candidate) {
                charSet[i++] = ch;
            }
            if(K>candidate.size()) {
                K = candidate.size();
            }
            dfs(new HashSet<>(), 0, 0);
        }
        System.out.println(precount+max);
    }
    public static void dfs(HashSet<Character> picked, int idx, int pick) {
        int count = 0;
        if(pick == K) {
            boolean impos;
            for(int i=0;i<w;i++) {
                impos = false;
                for(int j=0;j<wordSet[i].length();j++) {
                    if(!picked.contains(wordSet[i].charAt(j))) {
                        impos = true;
                        break;
                    }
                }
                if(!impos) count++;
            }
            max = Math.max(max, count);
            return;
        }
        for(int i=idx;i<candidate.size();i++) {
            if(!visit[i]) {
                visit[i] = true;
                picked.add(charSet[i]);
                dfs(picked, i, pick+1);
                visit[i] = false;
                picked.remove(charSet[i]);
            }
        }
    }
}

