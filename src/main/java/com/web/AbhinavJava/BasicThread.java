package com.web.AbhinavJava;

/**
 * Created by surap on 4/27/2017.
 */
public class BasicThread extends Thread {
    public void run() {
        for(int i = 0;i<50;i++) {
            System.out.println(getId() + "Hello from a thread!");
        }
    }

    public static void main(String args[]) {
        (new BasicThread()).start();
        (new BasicThread()).start();
        (new BasicThread()).start();
        (new BasicThread()).start();
    }
}
