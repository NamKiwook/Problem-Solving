import java.util.PriorityQueue;

public class FileSortingApplication {
    public static void main(String[] args){
        FileSorting fs = new FileSorting();
        String[] a = fs.solution(new String[] {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"});
        String[] b = fs.solution(new String[] {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"});
        return;
    }
}
class FileSorting {
    public String[] solution(String[] files) {

        PriorityQueue<File> pq = new PriorityQueue<>();

        for(int i = 0; i < files.length; i++) {
            int startNumber = 0;
            int endNumber = files[i].length();
            for(int j = 0; j < files[i].length(); j++) {
                if(files[i].charAt(j) >= '0' && files[i].charAt(j) <= '9') {
                    startNumber = j;
                    break;
                }
            }
            for(int j = startNumber; j < files[i].length(); j++) {
                if(files[i].charAt(j) < '0' || files[i].charAt(j) > '9') {
                    endNumber = j;
                    break;
                }
            }
            String fileName = files[i].substring(0,startNumber);
            int fileNumber = Integer.parseInt(files[i].substring(startNumber,endNumber));
            pq.add(new File(fileName, fileNumber, i));
        }

        String[] answer = new String[pq.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = files[pq.poll().index];
        }
        return answer;
    }
}

class File implements Comparable<File>{
    String name;
    int number;
    int index;
    public File(String name, int number, int index) {
        this.index = index;
        this.name = name;
        this.number = number;
    }

    @Override
    public int compareTo(File target) {
        if(!this.name.toLowerCase().equals(target.name.toLowerCase())) {
            return this.name.toLowerCase().compareTo(target.name.toLowerCase());
        } else if(this.number != target.number) {
            return this.number - target.number;
        } else {
            return this.index - target.index;
        }
    }
}
