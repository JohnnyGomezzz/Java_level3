package com.JohnnyGomezzz;

import com.JohnnyGomezzz.fruits.Apple;
import com.JohnnyGomezzz.fruits.Box;
import com.JohnnyGomezzz.fruits.Orange;

import java.util.ArrayList;
import java.util.Collections;

public class MainHomeWork1 {

//  1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
//  2. Написать метод, который преобразует массив в ArrayList;
//  3. Большая задача:
//    a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
//    b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку
//    нельзя сложить и яблоки, и апельсины;
//    c. Для хранения фруктов внутри коробки можете использовать ArrayList;
//    d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта(вес
//    яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
//    e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут
//    в compare в качестве параметра, true - если их веса равны, false в противном случае(коробки с яблоками мы можем
//    сравнивать с коробками с апельсинами);
//    f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку
//    фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается,
//    а в другую перекидываются объекты, которые были в этой коробке;
//    g. Не забываем про метод добавления фрукта в коробку.


    public static void swapArray(Object[] array, int firstObj, int secondObj) // задание 1
    {
        Object swap = array[firstObj];
        array[firstObj] = array[secondObj];
        array[secondObj] = swap;
    }

    public static <T> ArrayList<T> convertArrayList(T array[]) // задание 2
    {
        ArrayList<T> arrayList = new ArrayList<>();

        Collections.addAll(arrayList, array);

        return arrayList;
    }

    public static void main(String[] args) {

        Object[] array = {"ttt", 2, 3, 4, 5};

        swapArray(array, 0, 2);

        convertArrayList(array);

        // задание 3

        Box appleBox = new Box();
        Box orangeBox = new Box();

        appleBox.add(new Apple(6));
        appleBox.add(new Apple(3));
        orangeBox.add(new Orange(4));

        System.out.println(appleBox.getWeight());
        System.out.println(orangeBox.getWeight());

        System.out.println(appleBox.compare(orangeBox));

        Box appleBox2 = new Box();

        appleBox.pour(appleBox2);

        System.out.println(appleBox.getWeight());
        System.out.println(appleBox2.getWeight());

    }
}
