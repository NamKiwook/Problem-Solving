public class ThatSongApplication {
    public static void main(String[] args) {
        ThatSong s = new ThatSong();
        System.out.println(s.solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
        System.out.println(s.solution("CC#BCC#BCC#BCC#B", new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}));
        System.out.println(s.solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));

    }
}

class ThatSong{
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int ansTime = 0;
        for(int i = 0; i < musicinfos.length; i++){
            String[] temp = musicinfos[i].split(",");
            String[] start = temp[0].split(":");
            String[] end = temp[1].split(":");

            temp[3] = replaceSharp(temp[3]);
            m = replaceSharp(m);
            int time = (Integer.parseInt(end[0]) - Integer.parseInt(start[0])) * 60 + Integer.parseInt(end[1]) - Integer.parseInt(start[1]);
            String playRecord = "";
            for(int j = 0; j < time; j++) {
                playRecord += temp[3].charAt(j % temp[3].length());
            }
            if(playRecord.contains(m)) {
                if(ansTime < time) {
                    answer = temp[2];
                    ansTime = time;
                }
            }
        }
        if(ansTime == 0) {
            answer = "(None)";
        }

        return answer;
    }

    private String replaceSharp(String input) {
        input = input.replace("C#","H");
        input = input.replace("D#","I");
        input = input.replace("F#","J");
        input = input.replace("G#","K");
        input = input.replace("A#","L");
        return input;
    }
}
