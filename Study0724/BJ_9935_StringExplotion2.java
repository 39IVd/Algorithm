package Study0724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_9935_StringExplotion2 {
    static String longStr;
    static String exStr;
    static Stack<Character> stack = new Stack();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        longStr = br.readLine();
        exStr = br.readLine();
        for(int i=longStr.length()-1;i>=0;i--) {
            stack.push(longStr.charAt(i));
            if(longStr.charAt(i)==exStr.charAt(0) &&stack.size()>=exStr.length()) {
                boolean isSame = true;
                for(int j=0;j<exStr.length();j++) {
                    if(exStr.charAt(j)!= stack.get(stack.size()-1-j)) {
                        isSame = false;
                        break;
                    }
                }
                if(isSame) {
                    for(int j=0;j<exStr.length();j++) {
                        stack.pop();
                    }
                }
            }
        }
        if(stack.isEmpty()) {
            System.out.println("FRULA");
        }
        else {
            while(!stack.isEmpty()) {
                System.out.print(stack.pop());
            }
        }
    }
}


