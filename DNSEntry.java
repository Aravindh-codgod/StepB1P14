import java.util.*;

class DNSEntry {
    String ip;
    long expiry;

    DNSEntry(String ip,long ttl) {
        this.ip=ip;
        this.expiry=System.currentTimeMillis()+ttl;
    }
}

public class DNSCache {

    static HashMap<String,DNSEntry> cache = new HashMap<>();
    static int hit=0;
    static int miss=0;

    static String resolve(String domain) {
        DNSEntry e = cache.get(domain);
        if(e!=null && System.currentTimeMillis()<e.expiry) {
            hit++;
            return e.ip;
        }
        miss++;
        String ip="172.217.0."+new Random().nextInt(255);
        cache.put(domain,new DNSEntry(ip,5000));
        return ip;
    }

    static void stats() {
        int total=hit+miss;
        double rate = total==0?0:(hit*100.0/total);
        System.out.println("HitRate "+rate+"%");
    }

    public static void main(String[] args) {
        System.out.println(resolve("google.com"));
        System.out.println(resolve("google.com"));
        stats();
    }
}
