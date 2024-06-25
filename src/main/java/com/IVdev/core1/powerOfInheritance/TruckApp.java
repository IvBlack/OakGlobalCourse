package com.IVdev.core1.powerOfInheritance;

public class TruckApp {
    public static void main(String[] args) {

        Truck semi = new Truck(2, 200, 7, 44000);
        Truck pickup = new Truck(4, 29, 15, 2000);

        double gallons;
        int dist = 247;

        gallons = semi.fuelNeeded(dist);
        System.out.println("Полуприцеп типа semi может перевезти " +
                semi.getCargo() + " фунтов.");
        System.out.println("Для полуприцепа типа semi на дистанцию "
            + dist + " потребуется " + gallons + " галлонов топлива.");

        gallons = pickup.fuelNeeded(dist);
        System.out.println("Полуприцеп типа pickup может перевезти " +
                pickup.getCargo() + " фунтов.");
        System.out.println("Для полуприцепа типа semi на дистанцию "
                + dist + " потребуется " + gallons + " галлонов топлива.");
    }
}
