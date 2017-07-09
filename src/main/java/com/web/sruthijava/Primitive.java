package com.web.sruthijava;

/**
 * Created by chsru on 4/10/2017.
 */
public class Primitive {
        public static void main(String[] args) {
            Integer Obj = new Integer(127);

            byte b = Obj.byteValue();
            System.out.println(b);

            short s = Obj.shortValue();
            System.out.println(s);

            int i = Obj.intValue();
            System.out.println(i);

            float f = Obj.floatValue();
            System.out.println(f);

            double d = Obj.doubleValue();
            System.out.println(d);

            String str = new String("5");
            int a = Integer.parseInt(str);
            System.out.println(a);
            
            String strBinaryNumber = Integer.toBinaryString(i);
            System.out.println("Binary value of " + i + " is " + strBinaryNumber);

        }

}
