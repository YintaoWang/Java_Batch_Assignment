package com.yintaowang.assignment;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 3. give array of chars, combine them into string by using stream api
 */
public class StreamAPIHomework3 {

    public static String charArrayToString(char[] chars) {
        String str = Arrays.stream(new char[][]{chars}).map(String::valueOf).collect(Collectors.joining());
        return str;
    }

    //test
    public static void main(String[] args) {
        char[] chars0 = {'a', 'l', 'o', 'h', 'a'};
        char[] chars1 = {'a', 'l', 'o', 'h', 'a', ',', 'w', 'o', 'r', 'l', 'd'};
        System.out.println(charArrayToString(chars0));
        System.out.println(charArrayToString(chars1));
    }
}
