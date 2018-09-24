import java.util.HashMap;

public class F {
    public static void main(String[] args) {
        solution("Muzi", new String[] {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"});
    }
    public static int solution(String query, String[] pages) {
        int answer = 0;
        HashMap<String,Integer> page = new HashMap<>();
        String[][] pageLink = new String[pages.length][];
        int[] pageScore = new int[pages.length];
        for(int i = 0; i < pages.length; i++) {
            page.put(getPageName(pages[i]),i);
            pageLink[i] = getLink(pages[i]);
            String[] c = pages[i].split("[^a-zA-Z']+");
            for(int j = 0; j < c.length; j++) {
                if(c[j].toLowerCase().equals(query.toLowerCase())) pageScore[i]++;
            }
        }
        double[] score = new double[pages.length];
        for(int i = 0; i < pageLink.length; i++) {
            for(int j = 0; j < pageLink[i].length; j++) {
                if(page.containsKey(pageLink[i][j])) {
                    score[page.get(pageLink[i][j])] += (double) pageScore[i] / pageLink[i].length;
                }
            }
            score[i] += pageScore[i];
        }
        for(int i = 0; i < score.length; i++) {
            if(score[answer] < score[i]) answer = i;
        }
        return answer;
    }

    private static String[] getLink(String page) {
        String[] a = page.split("<a href=\"");
        String[] b = new String[a.length - 1];
        for(int j = 1; j < a.length; j++) {
             b[j-1] = a[j].split("\">")[0];
        }
        return b;
    }

    private static String getPageName(String page) {
        String a = page.split("<head>|</head>")[1];
        String b = a.split("<meta property=\"og:url\" content=")[1];
        return b.split("\"")[1];
    }
}
