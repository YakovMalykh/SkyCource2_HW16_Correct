package com.company;

public class Main {

    public static void main(String[] args) {
        StringListImpl strings = new StringListImpl(5);
        StringListImpl secondStrings = new StringListImpl(5);
        System.out.println(strings.add("www"));
        System.out.println(strings.add("rrr"));
        System.out.println(strings.add("aaa"));
//        System.out.println(strings.add("aaa"));
        System.out.println(strings);
//        System.out.println(strings.add(2,"jjj"));
//        System.out.println(strings);

        System.out.println(secondStrings.add("www"));
        System.out.println(secondStrings.add("rrr"));
        System.out.println(secondStrings.add("aaa"));
        System.out.println(secondStrings);

        System.out.println(strings.equals(secondStrings));
    }
}
