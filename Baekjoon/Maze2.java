package Baekjoon;

import java.util.*;
 
public class Maze2 {
 
    public static int size;
    public static int map[][];
    
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        
        // 입력 변수
        System.out.println("Size를 입력하시오:");
        size = sc.nextInt();
        
        map = new int [size][size];
        
        int a, b;
        System.out.println("간선을 입력하시오(종료 -1, -1):");
        
        while (true){
            a=sc.nextInt();
            b=sc.nextInt();
            if(a == -1 && b == -1) break;
            map[a][b]=1;
        }
        
        Dfs dfs = new Dfs(0,size,map);
        dfs.DfsAction();
    }
 
}
 
class Dfs{
    
    int start;
    int size;
    public static int[] token;
    public static int[][] map;
    
    Dfs(int a, int b, int[][] map){
        start = a;
        size = b;
        Dfs.map = map;
    }
    
    public void DfsAction(){
 
        // 방문 여부 저장
        token = new int[size];
        // start 정점 방문 표시
        token[start] = 1;
        // 큐 생성
        Stack<Integer> stack = new Stack<Integer>();
        // 시작 점 큐 입력
        stack.add(start);
        
        // Dfs 탐색 
        while(!stack.isEmpty()){
            // 큐에서 값 뺴오기
            int temp = stack.pop();
            System.out.println(temp);
            // 0~size 탐색
            for(int i = size-1; i>0 ;i--){
                // 길이 존재하고 방문하지 않았다면
                if(map[temp][i]==1 && token[i]==0){
                    // 큐에 추가
                    stack.add(i);
                    // 이동
                    token[temp]=1;
                }
            }
            
        }
        
    }
    
}
