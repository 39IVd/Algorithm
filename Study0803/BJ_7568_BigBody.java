package Study0803;

import java.util.Scanner;

class Person {
    int weight;
    int height;
    public Person(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }
}

public class BJ_7568_BigBody {
    static int N;
    static Person[] p;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        p = new Person[N];
        for(int i=0;i<N;i++) {
            int w = in.nextInt();
            int h = in.nextInt();
            p[i] = new Person(w, h);
        }
        int[] rank = new int[N];
        for(int i=0;i<N;i++) {
            rank[i] = 1;
            for(int j=0;j<N;j++) {
                if(i!=j && p[i].weight<p[j].weight&& p[i].height<p[j].height) {
                    rank[i]++;
                }
            }
        }
        for(int i=0;i<N;i++) {
            System.out.print(rank[i]+" ");
        }
    }
}
