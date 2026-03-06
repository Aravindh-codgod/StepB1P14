import java.util.*;

public class TwoSumTransactions {

    static void twoSum(int[] arr,int target) {
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<arr.length;i++) {
            int comp=target-arr[i];
            if(map.containsKey(comp))
                System.out.println(comp+" "+arr[i]);
            map.put(arr[i],i);
        }
    }

    public static void main(String[] args) {
        int[] t={500,300,200,700};
        twoSum(t,500);
    }
}
