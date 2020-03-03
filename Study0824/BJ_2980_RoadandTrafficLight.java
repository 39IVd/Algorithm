package Study0824;

import java.util.Scanner;

class TL {
    int d, r, g;
    int arrived, wait;
    public TL(int d, int r, int g, int arrived, int wait) {
        this.d = d;this.r=r;this.g=g;
        this.arrived = arrived;this.wait=wait;
    }
}
public class BJ_2980_RoadandTrafficLight {
    static int n, l;
    static TL[] tls;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); l = in.nextInt();
        tls = new TL[n];
        for(int i=0;i<n;i++) {
            tls[i] = new TL(in.nextInt(), in.nextInt(), in.nextInt(),0,0);
        }
        tls[0].arrived = tls[0].d;
        tls[0].wait = getLight(0, tls[0].arrived)-tls[0].arrived;
        for(int i=1;i<n;i++) {
            tls[i].arrived = tls[i-1].arrived + tls[i-1].wait + tls[i].d - tls[i-1].d;
            tls[i].wait = getLight(i, tls[i].arrived)-tls[i].arrived;
//            System.out.println(i+"번째 신호등의 도착 : "+tls[i].arrived);
//            System.out.println(i+"번째 신호등의 대기 : "+tls[i].wait);
        }
        int total = tls[n-1].arrived + tls[n-1].wait + l-tls[n-1].d;
        System.out.println(total);

    }
    public static int getLight(int i, int index) {
        // tls[i] 의 몇번쨰 index보다 크거나 같은 첫번째 g의 index?
        int r = tls[i].r; int g = tls[i].g;
        if(index%(r+g)<r+1) {
            return index/(r+g)*(r+g)+r;
        }
        else {
            return index;
        }
    }
}
