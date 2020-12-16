package com.JohnnyGomezzz.fruits;

import java.util.ArrayList;
import java.util.Arrays;

public class Box <T extends Fruit>{

    private ArrayList<T> fruitbox;

    public Box()
    {
        this.fruitbox = new ArrayList<>();
    }

    public void add(T fruit)
    {
        fruitbox.add(fruit);
    }

    public float getWeight()
    {
        float weight = 0.0f;

        for (T fruit : fruitbox)
        {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public boolean compare(Box<Fruit> another)
    {
        return Math.abs(this.getWeight() - another.getWeight()) < 0.001;
    }

    public void pour(Box<? super T> another)
    {
        if(another == this)
        {
            return;
        }
        another.fruitbox.addAll(this.fruitbox);
        this.fruitbox.clear();
    }
}
