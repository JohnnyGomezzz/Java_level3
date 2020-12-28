import java.util.Arrays;

public class NumArrays {

    /* 1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
    Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
    идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку, иначе в методе
    необходимо выбросить RuntimeException.
    Написать набор тестов для этого метода (по 3-4 варианта входных данных).
    Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].

    2. Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или
    единицы, то метод вернет false; Если есть элементы отличные от 1 и 4 то вернуть false. Написать набор тестов
    для этого метода (по 3-4 варианта входных данных).
    [ 1 1 1 4 4 1 4 4 ] -> true
    [ 1 1 1 1 1 1 ] -> false
    [ 4 4 4 4 ] -> false
    [ 1 4 4 1 1 4 3 ] -> false

     */


    // задание 1
    public int[] afterLastFour(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 4) {
                count++;
            }
            else {
                count = 0;
            }
            if (count == arr.length) {
                throw new RuntimeException("В массиве нет 4!");
            }
        }

        int[] newArray = new int[count];
        System.arraycopy(arr, arr.length - count, newArray, 0, count);

        return newArray;
    }

    // задание 2
    public boolean isOneFour(int[] arr) {

        int count1 = 0;
        int count4 = 0;

        for (int j : arr) {

            if (j == 1) {
                count1++;
            }
            if (j == 4) {
                count4++;
            }
        }
        if (count1 + count4 < arr.length) {
            return false;
        }
        if (count1 == arr.length) {
            return false;
        }
        return count4 != arr.length;

    }
}
