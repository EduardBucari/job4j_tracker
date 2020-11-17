package ru.job4j.oop;

public class MaxFrom3And4 {
    public static int max3(int first, int second, int third) {
        int temp =  first > second ? first : second;
        int max = temp > third ? temp : third;
        return max;
    }

    public static int max4(int first, int second, int third, int fourth) {
        int temp = first > second ? first : second;
        int temp2 = third > fourth ? third : fourth;
        int max = temp > temp2 ? temp : temp2;
        return max;
    }
     public static void main(String[] args) {
        int msg = MaxFrom3And4.max3(1, 2, 3);
        int msg2 = MaxFrom3And4.max4(1, 2, 3, 4);
        System.out.println(msg);
        System.out.println(msg2);
    }
}
