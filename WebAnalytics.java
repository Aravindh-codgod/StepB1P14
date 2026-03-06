import java.util.*;

public class WebAnalytics {

    static HashMap<String,Integer> views=new HashMap<>();
    static HashMap<String,Set<String>> unique=new HashMap<>();
    static HashMap<String,Integer> source=new HashMap<>();

    static void process(String url,String user,String src) {
        views.put(url,views.getOrDefault(url,0)+1);

        unique.putIfAbsent(url,new HashSet<>());
        unique.get(url).add(user);

        source.put(src,source.getOrDefault(src,0)+1);
    }

    static void dashboard() {
        System.out.println("Views "+views);
        System.out.println("Unique "+unique);
        System.out.println("Source "+source);
    }

    public static void main(String[] args) {
        process("/news","u1","google");
        process("/news","u2","facebook");
        process("/sports","u3","google");
        dashboard();
    }
}