import java.util.Iterator;
import java.util.TreeMap;

public class NewsClusteringApplication {
}
class NewsClustering{
    public int solution(String str1, String str2) {
        TreeMap<String, Integer> jaccardStr1 = new TreeMap<>();
        TreeMap<String, Integer> jaccardStr2 = new TreeMap<>();
        int result = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        setMap(str1, jaccardStr1);
        setMap(str2, jaccardStr2);

        TreeMap<String, Integer> tmp = new TreeMap<>();
        tmp.putAll(jaccardStr1);
        tmp.putAll(jaccardStr2);
        Iterator<String> itr = tmp.keySet().iterator();

        int u = 0;
        int n = 0;

        while(itr.hasNext()) {
            String next = itr.next();
            if(jaccardStr1.containsKey(next)) {
                if(jaccardStr2.containsKey(next)) {
                    int s1 = jaccardStr1.get(next);
                    int s2 = jaccardStr2.get(next);
                    u += Math.max(s1,s2);
                    n += Math.min(s1,s2);
                } else {
                    u += jaccardStr1.get(next);
                }
            } else if(jaccardStr2.containsKey(next)) {
                u += jaccardStr2.get(next);
            }
        }
        if(u == 0) {
            return 65536;
        }
        double r = (double) n / u ;
        result = (int) (r * 65536);
        return result;
    }

    private void setMap(String str, TreeMap<String, Integer> treeMap) {
        for(int i = 0; i < str.length() - 1; i++) {
            if(str.charAt(i) < 'a' || str.charAt(i) > 'z') continue;
            if(str.charAt(i + 1) < 'a' || str.charAt(i + 1) > 'z') continue;
            String tmp = str.substring(i,i+2);
            if(treeMap.containsKey(tmp)) {
                treeMap.replace(tmp,treeMap.get(tmp) + 1);
            } else {
                treeMap.put(tmp, 1);
            }
        }
    }
}