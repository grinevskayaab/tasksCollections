package com.githab.grinevskaya_ab;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //taskOne
        System.out.println(getIndexesForSum(new ArrayList<>(Arrays.asList(3, 8, 15, 17)), 23));
        System.out.println(getIndexesForSum(new ArrayList<>(Arrays.asList(3, 8, 17)), 23));
        System.out.println(getIndexesForSum(new ArrayList<>(Arrays.asList(3, 8, 1, 3, 4, 0, 17)), 17));
        System.out.println(getIndexesForSum(new ArrayList<>(Arrays.asList(3, -8, -15, 17)), -23));


        //taskTwo
        System.out.println(isDuplicateInList(new ArrayList<>(Arrays.asList(4, 5, 6, 6, 8))));
        System.out.println(isDuplicateInList(new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8))));
        System.out.println(isDuplicateInList(new ArrayList<>(Arrays.asList(3, -8, -15, 17))));
        System.out.println(isDuplicateInList(new ArrayList<>(Arrays.asList(3, -8, -8, -15, 17))));

        //taskTwo v2
        isDuplicateInListV2(new ArrayList<>(Arrays.asList(4, 5, 6, 6, 8)));
        isDuplicateInListV2(new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8)));
        isDuplicateInListV2(new ArrayList<>(Arrays.asList(3, -8, -15, 17)));
        isDuplicateInListV2(new ArrayList<>(Arrays.asList(3, 5, -8, -8, -15, 17, 17, 1, 1, 5, 5, 5, 9)));


        //testThree
        System.out.println(isValidBrackets("[()]{[]}"));
        System.out.println(isValidBrackets("[()](){[]}{[({})]}"));
        System.out.println(isValidBrackets(" [()]{[]}"));
        System.out.println(isValidBrackets("[({}])"));
        System.out.println(isValidBrackets("())"));
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
    public static List<Integer> getIndexesForSum(List<Integer> list, Integer sum) {
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

    //    Дан список целых чисел.
//    Необходимо реализовать метод, которые определяет, содержит ли данный список дубликаты
//
//    Пример:
//    List: [4,5,6,6,8]
//    Result: true
//    Число 6 повторяется 2 раза
//
//    List: [4,5,6,7,8]
//    Result: false
//    Дубликатов нет
    public static boolean isDuplicateInList(List<Integer> list) {
        Set<Integer> copyList = new HashSet<>();
        for (Integer number : list) {
            if (copyList.contains(number)) {
                return true;
            } else {
                copyList.add(number);
            }
        }
        return false;
    }

    public static void isDuplicateInListV2(List<Integer> list) {
        Map<Integer, Integer> counterNumber = new HashMap<>();
        for (Integer number : list) {
            if (counterNumber.containsKey(number)) {
                counterNumber.put(number, counterNumber.get(number) + 1);
            } else {
                counterNumber.put(number, 1);
            }
        }
        System.out.println("\nВ массиве " + list);
        outputDuplicate(counterNumber);
    }

    public static void outputDuplicate(Map<Integer, Integer> map) {
        Set<Integer> keys = new TreeSet<>(map.keySet());
        boolean isDuplicate = false;
        for (Integer key : keys) {
            Integer counterKey;
            if ((counterKey = map.get(key)) > 1) {
                System.out.println("Число " + key + " повторяется " + counterKey + " раз");
                if (!isDuplicate) isDuplicate = true;
            }
        }
        if (!isDuplicate) System.out.println("Нет повторяющихся элементов");
    }

    //    Дана строка состоящия из символов (){}[]. Строка является валидной, если каждая открывающая скобка корректно закрывается.
//    Необходимо определить является ли строка валидной
//
//    Пример:
//    String: [()]{[]}
//    Result: true
//    Все корректно
//
//    Пример: [({}])
//    Result: false
//    Скобка ] закрывает до закрытия скобки )
//
//    Пример: ())
//    Result: false
//    Скобка ) не открывалась
    public static boolean isValidBrackets(String str) {
        while (str.contains("{}") || str.contains("()") || str.contains("[]")) {
            str = str.replace("()", "")
                    .replace("{}", "")
                    .replace("[]", "");
        }

        return str.isEmpty();
    }
}
