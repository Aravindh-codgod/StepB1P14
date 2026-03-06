import java.util.*;

public class FlashSaleInventory {

    static HashMap<String,Integer> stock = new HashMap<>();
    static LinkedHashMap<Integer,String> waiting = new LinkedHashMap<>();

    static synchronized String purchase(String product,int user) {
        int s = stock.getOrDefault(product,0);
        if(s>0) {
            stock.put(product,s-1);
            return "Success remaining "+(s-1);
        }
        waiting.put(user,product);
        return "Added to waiting list position "+waiting.size();
    }

    static int checkStock(String product) {
        return stock.getOrDefault(product,0);
    }

    public static void main(String[] args) {
        stock.put("IPHONE15_256GB",5);
        System.out.println(checkStock("IPHONE15_256GB"));
        System.out.println(purchase("IPHONE15_256GB",1));
        System.out.println(purchase("IPHONE15_256GB",2));
        System.out.println(purchase("IPHONE15_256GB",3));
    }
}