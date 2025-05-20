package org.example.exerciseDesignPattern.exercise01;

public class Main {
    public static void main(String[] args) {

    HouseInfo house1 = new HouseInfo.Builder().floorNmbr(3).roofingType("Concrete").color("Red").pool(true).build();
    HouseInfo house2 = new HouseInfo.Builder().floorNmbr(5).roofingType("Metal").color("Black").pool(false).build();

        System.out.println(house1);

        System.out.println(house2);


    }
}

