import java.util.Arrays;
import java.util.Comparator;

public class ShuttleBusApplication {
}
class ShuttleBus{
    public String calc(int n, int t, int m, String[] timetable) {
        int[] minute = new int[timetable.length];
        for(int i=0; i < timetable.length; i++){
            minute[i] = Integer.parseInt(timetable[i].split(":")[0]) * 60;
            minute[i] += Integer.parseInt(timetable[i].split(":")[1]);
        }
        Arrays.sort(minute);
        int position = 0;
        int startTime = 540;
        boolean isEmpty = false;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(position >= minute.length) {
                    isEmpty =  true;
                    break;
                }
                if(minute[position] <= startTime)
                    position++;
                else {
                    if(i == n-1) {
                        isEmpty = true;
                    }
                    break;
                }
            }
            startTime += t;
        }
        String hh;
        String mm;
        if(isEmpty) {
            startTime -= t;
            if(startTime / 60 < 10) {
                hh = "0"+ String.valueOf(startTime / 60);
            } else {
                hh = String.valueOf(startTime / 60);
            }
            if(startTime % 60 < 10) {
                mm = "0" + String.valueOf(startTime % 60);
            } else {
                mm = String.valueOf(startTime % 60);
            }
        } else {
            position--;
            minute[position]--;
            if(minute[position] / 60 < 10) {
                hh = "0"+ String.valueOf(minute[position] / 60);
            } else {
                hh = String.valueOf(minute[position] / 60);
            }
            if(minute[position] % 60 < 10) {
                mm = "0" + String.valueOf(minute[position] % 60);
            } else {
                mm = String.valueOf(minute[position] % 60);
            }
        }
        return hh+":"+mm;
    }
}
