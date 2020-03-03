package KakaoCodingTest2018;

import java.util.StringTokenizer;

// 거꾸로 가면서 검사
// 마지막 enter와 change의 id와 닉네임을 일치시킨다
// 이전의 닉네임도 같이 매칭

public class OpenChattingRoom {
    static String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234",
            "Enter uid1234 Prodo","Change uid4567 Ryan"};
    static String[][] rec;
//    static String[] ans = {"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.",
//            "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."};
    static String[][] ans;
    public static void main(String[] args) {
        System.out.println(solution(record));
    }
    public static String[] solution(String[] record) {
        String[] answer = {};
        rec = new String[record.length][3];
        ans = new String[record.length][2];
        for(int i=0;i<record.length;i++) {
            StringTokenizer st = new StringTokenizer(record[i], " ");
            int cnt = 0;
            while(st.hasMoreTokens()) {
                rec[i][cnt] = st.nextToken();
                cnt++;
            }
        }
        for(int i=0;i<record.length;i++) {
            for(int j=0;j<3;j++) {
                System.out.print(rec[i][j]+" ");
            }
            System.out.println();
        }
        int cnt = 0;
        for(int i=0;i<record.length;i++) {
            if(rec[i][0].equals("Enter")) {
                ans[cnt][1] = "님이 들어왔습니다.";
                cnt++;
            }
            else if(rec[i][0].equals("Leave")) {
                ans[cnt][1] = "님이 나갔습니다.";
                cnt++;
            }
            else if(rec[i][0].equals("Change")) {

            }
            for(int j=0;j<2;j++) {

            }
            System.out.println();
        }

        return answer;
    }
}
