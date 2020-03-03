package BackTracking;

import java.util.Scanner;

public class BJ_3407_Promise {
    static Scanner in = new Scanner(System.in);
    static char s1[] = { 'h', 'b', 'c', 'n', 'o', 'f', 'p', 's', 'k', 'v', 'y', 'i', 'w', 'u' };
    static String s2[] = {
        "ba", "ca" , "ga", "la", "na", "pa", "ra", "ta", "db", "nb", "pb", "rb", "sb", "tb", "yb", "ac",
                "sc", "tc", "cd", "gd", "md", "nd", "pd", "be", "ce", "fe", "ge", "he", "ne", "re", "se", "te",
                "xe", "cf", "hf", "rf", "ag", "hg", "mg", "rg", "sg", "bh", "rh", "th", "bi", "li", "ni", "si",
                "ti", "bk", "al", "cl", "fl", "tl", "am", "cm", "fm", "pm", "sm", "tm", "cn", "in", "mn", "rn",
                "sn", "zn", "co", "ho", "mo", "no", "po", "np", "ar", "br", "cr", "er", "fr", "ir", "kr", "lr",
                "pr", "sr", "zr", "as", "cs", "ds", "es", "hs", "os", "at", "mt", "pt", "au", "cu", "eu", "lu",
                "pu", "ru", "lv", "dy"
    };
    static int n;
    static String[] words;
    static String[] ans;
    public static void main(String[] args) {
        n = in.nextInt();
        in.nextLine();
        words = new String[n]; ans = new String[n];
        for(int i=0;i<n;i++){
            words[i] = in.nextLine();
            for(int j=0;j<words[i].length();j++) {

            }
        }
    }
}
