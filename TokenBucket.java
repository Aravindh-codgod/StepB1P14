import java.util.*;

class TokenBucket {
    int tokens;
    long last;
}

public class RateLimiter {

    static HashMap<String,TokenBucket> map=new HashMap<>();
    static int limit=5;

    static boolean allow(String client) {
        long now=System.currentTimeMillis();
        map.putIfAbsent(client,new TokenBucket());
        TokenBucket b=map.get(client);

        if(now-b.last>3600000) {
            b.tokens=0;
            b.last=now;
        }

        if(b.tokens<limit) {
            b.tokens++;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        for(int i=0;i<7;i++)
            System.out.println(allow("abc123"));
    }
}