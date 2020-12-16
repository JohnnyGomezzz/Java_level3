package com.JohnnyGomezzz.fruits;

public abstract class Fruit {

    private float weight;
    private int count = 0;

    public Fruit(float weight, int count)
    {
        this.weight = weight;
        this.count = count;
    }

    public float getWeight()
    {
        return weight * count;
    }
}
