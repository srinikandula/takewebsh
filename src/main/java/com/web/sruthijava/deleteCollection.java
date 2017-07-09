package com.web.sruthijava;

import java.util.ArrayList;

/**
 * Created by chsru on 7/6/2017.
 */
public class deleteCollection {
    public static void main(String a[]){
        ArrayList<String> arrl = new ArrayList<String>();
        arrl.add("1");
        arrl.add("2");
        arrl.add("3");
        arrl.add("4");
        System.out.println("Given ArrayList:"+arrl);
        arrl.clear();
        System.out.println("ArrayList after deleting:"+arrl);
    }
}
