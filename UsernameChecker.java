import java.util.*;

public class UsernameChecker {

    static HashMap<String,Integer> users = new HashMap<>();
    static HashMap<String,Integer> attempts = new HashMap<>();

    static boolean checkAvailability(String username) {
        attempts.put(username, attempts.getOrDefault(username,0)+1);
        return !users.containsKey(username);
    }

    static List<String> suggest(String username) {
        List<String> list = new ArrayList<>();
        for(int i=1;i<=3;i++) list.add(username+i);
        list.add(username.replace("_","."));
        return list;
    }

    static String mostAttempted() {
        String res="";
        int max=0;
        for(String k:attempts.keySet()) {
            if(attempts.get(k)>max) {
                max=attempts.get(k);
                res=k;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        users.put("john_doe",1);
        users.put("admin",2);

        System.out.println(checkAvailability("john_doe"));
        System.out.println(checkAvailability("jane_smith"));
        System.out.println(suggest("john_doe"));
        System.out.println(mostAttempted());
    }
}