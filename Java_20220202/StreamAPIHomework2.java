package com.yintaowang.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;

/**
 * 2. given list of integer, use stream to split list into List<List> (idx 0: odd list, idx 1: even list)
 * in one line
 */
public class StreamAPIHomework2 {

    public static List<List<Integer>> listToNestedListsOddEven(List<Integer> numbers) {
        List<List<Integer>> nestedList = numbers.stream().collect(Collector.of(ArrayList::new, (accumulator, num) -> {
                    if (accumulator.isEmpty()) {
                        accumulator.add(new ArrayList<>());
                        accumulator.add(new ArrayList<>());
                    }
                    if (num % 2 != 0) {
                        accumulator.get(0).add(num);
                    } else {
                        accumulator.get(1).add(num);
                    }
                }, (l1, l2) -> {
                    l1.addAll(l2);
                    return l1;
                }
        ));
        return nestedList;
    }

    //test
    public static void main(String[] args) {
        List<Integer> numbers0 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 9, 10);
        List<Integer> numbers2 = Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
        System.out.println(listToNestedListsOddEven(numbers0));
        System.out.println(listToNestedListsOddEven(numbers1));
        System.out.println(listToNestedListsOddEven(numbers2));

        //partitioningBy
//        Map<Boolean, List<Integer>> splited = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
//        System.out.println(splited);
//        System.out.println(splited.get(true));
//        System.out.println(splited.get(false));
    }
}

