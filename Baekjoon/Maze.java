package Baekjoon;

import java.util.Map.Entry;
import java.util.AbstractMap;
import java.util.Scanner;
import java.util.Stack;
 
public class Maze {
  public static Integer N = null;
  public static Integer M = null;
  public static boolean map[][] = null;
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
     
    N = scanner.nextInt();
    M = scanner.nextInt();
    map= new boolean[M][N]; // [X][Y]
 
    Integer accessCnt[][] = new Integer[M][N]; // [X][Y]
     
    for(int i = 0; i<N; i++) {
      String nextStr = scanner.next();
      for(int j = 0; j<M; j++) {
        Character nextChar = nextStr.charAt(j);
        if(nextChar == '1') {
          map[j][i] = true; 
        }else {
          map[j][i] = false;
        }
        accessCnt[j][i] = Integer.MAX_VALUE;
      }
    }
     
    Stack<Entry<Integer, Integer>> stack = new Stack<Entry<Integer, Integer>>();
    stack.add(makePair(0, 0));
     
    accessCnt[0][0] = 1;
     
    while(!stack.isEmpty()) {
      Entry<Integer, Integer> next = stack.pop();
       
      Integer X = next.getKey(); 
      Integer Y = next.getValue();
       
      Integer currCnt = accessCnt[X][Y]; 
       
      if(canMove(X-1, Y)) {
        if(accessCnt[X-1][Y] > currCnt + 1){
          accessCnt[X-1][Y] = currCnt+1;
          stack.add(makePair(X-1, Y));  
        }
      }
      if(canMove(X+1, Y)) { 
        if(accessCnt[X+1][Y] > currCnt + 1){
          accessCnt[X+1][Y] = currCnt+1;
          stack.add(makePair(X+1, Y));    
        }
      }
      if(canMove(X, Y-1)) {
        if(accessCnt[X][Y-1] > currCnt + 1){
          accessCnt[X][Y-1] = currCnt+1;
          stack.add(makePair(X, Y-1)); 
        }
      }
      if(canMove(X, Y+1)) { 
        if(accessCnt[X][Y+1] > currCnt + 1){
          accessCnt[X][Y+1] = currCnt+1;
          stack.add(makePair(X, Y+1));  
        }
      }
    }
    System.out.println(accessCnt[M-1][N-1]);
  }
  public static Entry<Integer,Integer> makePair(Integer key,Integer value) {
    return new AbstractMap.SimpleEntry<Integer,Integer>(key,value);
  }
  public static boolean canMove(Integer x,Integer y){
    if(x < 0 || x >= M || y < 0 || y >= N) return false;
    return map[x][y];
  }
}
