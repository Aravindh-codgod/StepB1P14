import java.util.*;

public class MultiLevelCache {

    static LinkedHashMap<String,String> L1 =
            new LinkedHashMap<>(16,0.75f,true);

    static HashMap<String,String> L2=new HashMap<>();
    static HashMap<String,String> DB=new HashMap<>();

    static String get(String id) {

        if(L1.containsKey(id)) return "L1 "+L1.get(id);

        if(L2.containsKey(id)) {
            String v=L2.get(id);
            L1.put(id,v);
            return "L2 "+v;
        }

        if(DB.containsKey(id)) {
            String v=DB.get(id);
            L2.put(id,v);
            return "DB "+v;
        }

        return "NotFound";
    }

    public static void main(String[] args) {

        DB.put("video1","data1");
        DB.put("video2","data2");

        System.out.println(get("video1"));
        System.out.println(get("video1"));
    }
}