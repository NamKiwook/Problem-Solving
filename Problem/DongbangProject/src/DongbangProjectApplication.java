import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class DongbangProjectApplication {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());
        DongbangProject dp = new DongbangProject();
        dp.setNumberRoom(parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        int N = parseInt(st.nextToken());
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            dp.actVillain(parseInt(st.nextToken()),parseInt(st.nextToken()));
        }
        System.out.print(dp.getNumberRoom());
    }

}
class DongbangProject{
    boolean[] dongbang;
    public void setNumberRoom(int inputRoom) {
        dongbang = new boolean[inputRoom+1];
        dongbang[0] = false;
        for(int i = 1; i < inputRoom+1; i++){
            dongbang[i] = true;
        }
    }

    public void actVillain(int startAct, int endAct) {
        for(int i = startAct+1; i <= endAct; i++) {
            dongbang[i] = false;
        }
    }

    public int getNumberRoom() {
        int count = 0;
        for(int i = 0; i < dongbang.length; i++) {
            if(dongbang[i])
                count++;
        }
        return count;
    }
}
