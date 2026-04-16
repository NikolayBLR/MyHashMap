//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MyHashMap <Integer,Integer> hashMap = new MyHashMap<>();
        hashMap.put(1,5);
        Integer get1 = hashMap.get(1);
        Integer value = hashMap.remove(1);
        System.out.println(get1);
        System.out.println(value);
    }

}