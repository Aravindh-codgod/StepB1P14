public class ParkingLot {

    static String[] table=new String[10];

    static int hash(String plate) {
        return Math.abs(plate.hashCode())%table.length;
    }

    static int park(String plate) {
        int i=hash(plate);
        int start=i;

        while(table[i]!=null) {
            i=(i+1)%table.length;
            if(i==start) return -1;
        }

        table[i]=plate;
        return i;
    }

    static void exit(String plate) {
        for(int i=0;i<table.length;i++)
            if(plate.equals(table[i])) table[i]=null;
    }

    public static void main(String[] args) {
        System.out.println(park("ABC123"));
        System.out.println(park("XYZ999"));
        exit("ABC123");
    }
}