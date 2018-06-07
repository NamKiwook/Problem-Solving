import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class WarringApplication {
    public static void main(String[] arg) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Warring warring = new Warring(N);
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            warring.inputArmy(Integer.parseInt(st.nextToken()));
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            warring.inputRecord(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()) - 1,Integer.parseInt(st.nextToken()) - 1);
        }
        Map<String, int[]> result = warring.warResult();
        System.out.println(result.get("numberCountry")[0]);
        for(int i = 0; i < result.get("resultArmy").length; i++) {
            if(result.get("resultArmy")[i] != 0) {
                System.out.print(result.get("resultArmy")[i] + " ");
            }
        }

    }
}
class Warring {
    Country[] countries;
    int[] pointCountry;
    int inputArmsCount = 0;
    public Warring (int numberCountry) {
        countries = new Country[numberCountry];
        pointCountry = new int[numberCountry];
        for(int i = 0; i < numberCountry; i++) {
            countries[i] = new Country();
            pointCountry[i] = i;
        }
    }

    public void inputArmy(int army) {
        countries[inputArmsCount++].setArmy(army);
    }
    public void inputRecord(int flag, int countryA, int countryB) {
        while(pointCountry[countryA] != countryA) {
            if(pointCountry[countryA] == -1){
                return;
            }
            countryA = pointCountry[countryA];
        }
        while(pointCountry[countryB] != countryB) {
            if(pointCountry[countryB] == -1){
                return;
            }
            countryB = pointCountry[countryB];
        }
        if (flag == 1) {
            int sumArmy = countries[countryA].getArmy() + countries[countryB].getArmy();
            countries[countryA].setArmy(sumArmy);
            countries[countryB] = countries[countryA];
            pointCountry[countryB] = countryA;
        } else if (flag == 2) {
            int subArmy = countries[countryA].getArmy() - countries[countryB].getArmy();
            if(subArmy < 0) {
                countries[countryB].setArmy(Math.abs(subArmy));
                countries[countryA] = countries[countryB];
                pointCountry[countryA] = countryB;
            } else if(subArmy > 0){
                countries[countryA].setArmy(subArmy);
                countries[countryB] = countries[countryA];
                pointCountry[countryB] = countryA;
            } else {
                countries[countryA].setArmy(subArmy);
                countries[countryB] = countries[countryA];
                pointCountry[countryA] = -1;
                pointCountry[countryB] = -1;
            }
        }
    }

    public Map<String,int[]> warResult() {
        int[] resultArmy = new int[pointCountry.length];
        int numberCountry = 0;
        for(int i = 0; i < pointCountry.length; i++) {
            if(pointCountry[i] == i) {
                resultArmy[i] = countries[i].getArmy();
                numberCountry++;
            } else {
                resultArmy[i] = 0;
            }
        }
        Arrays.sort(resultArmy);
        Map<String, int[]> returnValue = new HashMap<String,int[]>();
        returnValue.put("resultArmy",resultArmy);
        returnValue.put("numberCountry", new int[]{numberCountry});
        return returnValue;
    }
    class Country {
        int army = 0;
        public void setArmy(int army) {
            this.army = army;
        }
        public int getArmy() {
            return army;
        }
    }
}
