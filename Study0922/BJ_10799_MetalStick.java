package Study0922;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class BJ_10799_MetalStick {
    static ArrayList<Integer> laser = new ArrayList<>();
    static String[] arr;
    static Stack<Integer> st = new Stack<>();
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        arr = s.split("");
        for(int i=0;i<arr.length;i++) {
            if(i<arr.length-1) {
                if(arr[i].equals("(")&&arr[i+1].equals(")")) {
                    laser.add(i);
//                    System.out.println("laser : "+i);
                    i++;
                }
                else if(arr[i].equals("(")) {
                    st.push(i);
                }
                else {
                    int start = st.pop();
                    int end = i;
                    cnt++;
//                    System.out.print("stick : ("+start+", "+end+") ");
//                    int sc = 0;
                    for(int j=0;j<laser.size();j++) {
                        if(laser.get(j)>start&&laser.get(j)<end) {
                            cnt++;
                            start = laser.get(j);
//                            sc++;
                        }
                    }
//                    System.out.println(sc+" 조각");
                }
            }
            else {
                int start = st.pop();
                int end = i;
                cnt++;
//                System.out.println("stick : ("+start+", "+end+")");
                for(int j=0;j<laser.size();j++) {
                    if(laser.get(j)>start&&laser.get(j)<end) {
                        cnt++;
                        start = laser.get(j);
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
