package com.web.sruthijava;

import java.util.HashSet;

/**
 * Created by chsru on 7/6/2017.
 */
public class hashSet {
    public static void main(String a[]) {
        HashSet<String> hs = new HashSet<String>();
        hs.add("1");
        hs.add("2");
        hs.add("3");
        System.out.println(hs);
        System.out.println("Check if HashSet empty? " + hs.isEmpty());
        hs.remove("3");
        System.out.println(hs);
        System.out.println("Size of the HashSet: " + hs.size());
        System.out.println("Does HashSet contains first element? " + hs.contains("1"));
    }
}
