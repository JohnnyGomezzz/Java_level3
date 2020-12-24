package com.JohnnyGomezzz;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {

    Semaphore smp;

    public Tunnel() {
        smp = new Semaphore(MainClass.CARS_COUNT / 2);
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }
    @Override
    public void go(Car c) {

                try {
                    if (!smp.tryAcquire()) {
                        System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                        smp.acquire();
                    }

                    System.out.println(c.getName() + " начал этап: " + description);
                    Thread.sleep(length / c.getSpeed() * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(c.getName() + " закончил этап: " + description);
                    smp.release();
                }
    }
}
