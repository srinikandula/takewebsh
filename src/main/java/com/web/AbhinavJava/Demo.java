package com.web.AbhinavJava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by surap on 4/27/2017.
 */
public class Demo {
    static final long serialVersionUID = 1L;
    public static void main(String[] args) throws Exception {

        User userWrite = new User(1, "Abhinav", "abhirocksnow@gmail.com", 123456789);
        FileOutputStream fos = new FileOutputStream("accounts/testfile");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(userWrite);
        oos.flush();
        oos.close();

        User userRead;
        FileInputStream fis = new FileInputStream("accounts/testfile");
        ObjectInputStream ois = new ObjectInputStream(fis);
        userRead = (User)ois.readObject();
        ois.close();

        System.out.println("username: " + userRead.getUsername());
        System.out.println("ssn: " + userRead.getSsn());
        System.out.println("UID " + serialVersionUID);
    }
}
