package algorithms;

public class Main {


    public static void main(String[] args) {
        HashTable HT = new HashTable();

        HT.put("John", 1);
        HT.put("Michael", 2);
        HT.put("Sharon", 3);
        System.out.println(HT.get("Michael"));
        HT.delete("Michael");
        System.out.println(HT.get("Michael"));
    }

}
