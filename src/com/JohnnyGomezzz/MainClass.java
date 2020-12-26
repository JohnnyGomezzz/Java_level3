package com.JohnnyGomezzz;

import java.util.concurrent.CyclicBarrier;

public class MainClass {

    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(MainClass.CARS_COUNT + 1);

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        Race race = new Race(new Road(60), new Tunnel(), new Road(40));

        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cyclicBarrier);
        }

        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

        try {
            cyclicBarrier.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

            cyclicBarrier.await();

            cyclicBarrier.await();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
