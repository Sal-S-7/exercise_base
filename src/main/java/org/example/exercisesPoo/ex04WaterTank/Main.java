package org.example.exercisesPoo.ex04WaterTank;

public class Main {
    public static void main(String[] args) {
        WaterTank tank1 = new WaterTank(100, 1000, 10);

        System.out.println("Volume total du WaterTank : " + WaterTank.getVolumeTotal());

        tank1.remplir(100);
        System.out.println("Volume total du WaterTank après remplissage de tank1 : " + WaterTank.getVolumeTotal());
        System.out.println("Poids total de la citerne 1 : " + tank1.getPoidsTotal() + "Kg");
        tank1.vider(50);
        System.out.println("Volume total du WaterTank après vidage de tank1 : " + WaterTank.getVolumeTotal());

        System.out.println("Poids total de la citerne 1 : " + tank1.getPoidsTotal() + "Kg");
    }
}