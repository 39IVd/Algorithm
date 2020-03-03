package Study0724;

import java.util.Scanner;

public class BJ_9935_StringExplotion {
    static String longStr;
    static String exStr;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        longStr = scan.nextLine();
        exStr = scan.nextLine();

        while(longStr.contains(exStr)) {
            longStr = longStr.replaceAll(exStr, "");
        }
        if(longStr.equals("")) {
            System.out.println("FRULA");
        }
        else {
            System.out.println(longStr);
        }
    }
}
