import java.util.*;

public class Autocomplete {

    static HashMap<String,Integer> freq=new HashMap<>();

    static void add(String q) {
        freq.put(q,freq.getOrDefault(q,0)+1);
    }

    static List<String> search(String prefix) {
        List<String> list=new ArrayList<>();
        for(String q:freq.keySet())
            if(q.startsWith(prefix)) list.add(q);

        list.sort((a,b)->freq.get(b)-freq.get(a));
        return list.subList(0,Math.min(10,list.size()));
    }

    public static void main(String[] args) {
        add("java tutorial");
        add("javascript");
        add("java download");
        add("java tutorial");

        System.out.println(search("jav"));
    }
}