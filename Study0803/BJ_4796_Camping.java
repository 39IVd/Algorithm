package Study0803;

import java.util.Scanner;

class Case {
    int L, P, V;
    public Case(int L, int P, int V) {
        this.L = L;
        this.P = P;
        this.V = V;
    }
}

public class BJ_4796_Camping {
    static Case[] cases = new Case[1000];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cnt = 0;
        while(true) {
            int l = in.nextInt();
            int p = in.nextInt();
            int v = in.nextInt();
            if(l==0) {
                break;
            }
            else {
                cases[cnt] = new Case(l, p, v);
                cnt++;
            }
        }
        for(int i=0;i<cnt;i++) {
            int result = (int)(cases[i].V/cases[i].P)*cases[i].L
                    +Math.min(cases[i].L, (cases[i].V%cases[i].P));
            System.out.println("Case "+(i+1)+": "+result);
        }
    }
}
