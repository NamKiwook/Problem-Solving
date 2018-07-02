import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CacheApplication {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(),"[],\" ");
        ArrayList<String> input = new ArrayList<>();
        while(st.hasMoreTokens()){
            input.add(st.nextToken());
        }
        String[] inputArr = new String[input.size()];
        input.toArray(inputArr);
        Cache c = new Cache();
        System.out.print(c.calc(n,inputArr));
    }
}

class Cache{
    final int CacheHit = 1;
    final int CacheMiss = 5;
    public int calc(int cache, String[] input) {
        LRU lru = LRU.newInstance(cache);
        int time = 0;
        for(int i = 0; i < input.length; i++) {
            input[i] = input[i].toLowerCase();
            if(lru.containsKey(input[i]))
                time += CacheHit;
            else
                time += CacheMiss;
            lru.put(input[i],input[i]);
        }
        return time;
    }

}

class LRU<K, V> extends LinkedHashMap<K, V> {
    private int size;

    private LRU(int size) {
        super(size, 0.75f, true);
        this.size = size;
    }
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > size;
    }
    public static <K,V> LRU<K,V> newInstance(int size) {
        return new LRU<K,V>(size);
    }
}
