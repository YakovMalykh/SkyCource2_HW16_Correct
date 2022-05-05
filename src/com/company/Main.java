package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        StringListImpl strings = new StringListImpl(5);
        StringListImpl secondStrings = new StringListImpl(5);
        System.out.println(strings.add("www"));
        System.out.println(strings.add("rrr"));
        System.out.println(strings.add("aaa"));
//        System.out.println(strings.add(4,"ggg"));
        System.out.println(strings);
        System.out.println(strings.remove(0));
        System.out.println(strings);
//        System.out.println(strings.remove(1));
//        System.out.println(strings);


    }
}
