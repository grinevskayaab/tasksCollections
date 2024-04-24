package com.githab.grinevskaya_ab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //taskOne
        System.out.println(taskOne(new ArrayList<>(Arrays.asList(3, 8, 15, 17)), 23));
        System.out.println(taskOne(new ArrayList<>(Arrays.asList(3, 8, 17)), 23));
        System.out.println(taskOne(new ArrayList<>(Arrays.asList(3, 8, 1, 3, 4, 0, 17)), 17));
        System.out.println(taskOne(new ArrayList<>(Arrays.asList(3, -8, -15, 17)), -23));
    }


    //    Дан список целых чисел. Необходимо реализовать метод, который возвращает индексы списка, значения которых в сумме дают число переданное в метод.
//
//    Предполагается, что список содержит только уникальные числа и всегда имеет искомые числа.
//    Один и тот же элемент не может быть использован дважды.
//
//    List = [3, 8, 15, 17], Number = 23
//    result = [1,2]
//
//    Т.е. индексы 1 и 2 (значение 8 и 15) в сумме дают искомое число 23
    public static List<Integer> taskOne(List<Integer> list, Integer sum) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            int index;
            if ((index = list.indexOf(sum - list.get(i))) != -1) {
                result.add(i);
                result.add(index);
                break;
            }
        }
        return result;
    }
}