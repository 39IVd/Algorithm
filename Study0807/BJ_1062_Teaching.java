package Study0807;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class BJ_1062_Teaching {
    static int N, K;
    static HashSet<Character>[] set;
    static HashSet<Character> r = new HashSet<>();
    static HashSet<Character> all = new HashSet<>();
    static int max = 0;
    static char ch[];
    static Stack<Character> st = new Stack<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt(); K = in.nextInt();
        in.nextLine();
        set = new HashSet[N];
        for(int i=0;i<N;i++) {
            String str = in.nextLine();
            str = str.replaceAll("[antic]", "");
            set[i] = new HashSet<>();
            for(int j=0;j<str.length();j++) {
                set[i].add(str.charAt(j));
                all.add(str.charAt(j));
            }
        }
        Iterator it = all.iterator();
        ch = new char[all.size()];
        int l=0;
        while(it.hasNext()) {
            ch[l] = (char)it.next();
            l++;
        }
//        System.out.print("ch[] : ");
//        for(int i=0;i<ch.length;i++) {
//            System.out.print(ch[i]+" ");
//        }
//        System.out.println();
        // nCr = n!/((n-r)!r!)

        // ch[] 에서 ch.length개 중 k-5개를 뽑아 r에 저장
        doCombination(ch.length, K-5, 0);
//        System.out.println("set ");
//        for(int i=0;i<N;i++) {
//            System.out.print(set[i]+" ");
//        }
//        System.out.println();
        System.out.println(max);
    }
    public static void showStack() {
        for(int i=0;i<st.size();i++){
            r.add(st.get(i));
        }
        max = Math.max(max, cal());
        r.clear();
    }
    public static void doCombination(int n, int r, int index) {
        if(r==0) {
            showStack();
            return;
        }
        else if(n==r) {
            for(int i=0;i<n;i++) {
                st.add(ch[index+i]);
            }
            showStack();
            for(int i=0;i<n;i++)st.pop();
        }
        else{
            st.add(ch[index]);
            doCombination(n-1,r-1,index+1);
            st.pop();
            doCombination(n-1, r, index+1);
        }
    }
    public static int cal() {
        int cnt =0;
//        System.out.print("r : "+r+"-> ");
        for(int i=0;i<set.length;i++) {
            HashSet tmp = new HashSet();
            tmp.addAll(set[i]);
            tmp.removeAll(r);
//            System.out.print(tmp);
            if(tmp.size()==0) {
                cnt++;
            }
        }
//        System.out.println();
        return cnt;
    }
}

