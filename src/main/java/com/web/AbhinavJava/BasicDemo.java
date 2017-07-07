package com.web.AbhinavJava;
import static java.lang.Math.*;

/**
 * Created by surap on 4/10/2017.
 */
public class BasicDemo {
    public static void main(String[] args) {
        double a = -191.635;
        double b = 43.74;
        int c = (int)(random() * 10);
        int d = (int)(random() * 20);
        String oneAsString = Integer.toString(c);
        int two = Integer.parseInt(oneAsString);
        System.out.println(oneAsString);
        System.out.println(oneAsString + c);
        System.out.println(two + c);

        System.out.printf("The absolute value of %.3f is %.3f%n", a, abs(a));

        System.out.printf("The ceiling of %.2f is %.0f%n", b, ceil(b));

        System.out.printf("The floor of %.2f is %.0f%n", b, floor(b));

        System.out.printf("The rint of %.2f is %.0f%n", b, rint(b));

        System.out.printf("The max of %d and %d is %d%n", c, d, max(c, d));

        System.out.printf("The min of of %d and %d is %d%n", c, d, min(c, d));
    }
}