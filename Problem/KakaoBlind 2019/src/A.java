import java.util.ArrayList;
import java.util.HashMap;

public class A {
    public static void main(String[] args) {
        String[] a = solution(new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
        return;
    }
    public static String[] solution(String[] record) {
        HashMap<String,String> user = new HashMap<>();
        ArrayList<String> ans = new ArrayList<>();
        for(int i = 0; i < record.length; i++) {
            String[] recordInfo = record[i].split(" ");
            if(recordInfo[0].equals("Enter")) {
                user.put(recordInfo[1],recordInfo[2]);
            } else if(recordInfo[0].equals("Change")) {
                user.replace(recordInfo[1],recordInfo[2]);
            }
        }
        for(int i = 0; i < record.length; i++) {
            String[] recordInfo = record[i].split(" ");
            if(recordInfo[0].equals("Enter")) {
                ans.add(user.get(recordInfo[1]) + "님이 들어왔습니다.");
            } else if(recordInfo[0].equals("Leave")) {
                ans.add(user.get(recordInfo[1]) + "님이 나갔습니다.");
            }
        }
        String[] answer = new String[ans.size()];
        answer = ans.toArray(answer);

        return answer;
    }
}
