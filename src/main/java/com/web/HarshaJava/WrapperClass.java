package com.web.HarshaJava;

public class WrapperClass {

        public static void main (String args[]){
            Integer Obj1 = new Integer (25);
            Integer Obj2 = new Integer ("25");
            Integer Obj3= new Integer (35);
            System.out.println("Comparing Obj1 and Obj2: " + Obj1.compareTo(Obj2));
            System.out.println("Comparing  Obj1 and Obj3: " + Obj3.compareTo(Obj1));
            System.out.println("Is  Obj1 equal to Obj2: " + Obj1.equals(Obj2));
            System.out.println("Is Obj1 equal to Obj3: " + Obj1.equals(Obj3));
            Float f1 = new Float("2.25f");
            Float f2 = new Float("20.43f");


            float z = 2.25f;

            Float f3 = new Float( z);

            int ash =123;
            Integer jfk = ash;
            Integer jfk1 = new Integer(ash);

            int xyz = jfk1;
            int xys = jfk.intValue();

            System.out.format("%d,  %d,  %d,  ", ash,xyz,xys);



            Float f4 = Obj2.floatValue() + f1;
            Float f5 = Obj1.floatValue() + f2;
            float obj = Obj2.floatValue();
            float F1 = f1;
            float  F4 = f4;
            System.out.println("Addition of Obj2 and f2: "+ Obj1 +"+" +f1+"=" +f5 );
            System.out.format("Addition of Obj2 and f1: %f + %f = %f %n", obj,F1,F4 );
            String check = "101";
            int j = Integer.parseInt(check);
            int x = Integer.parseInt(check, 2);
            String qwe =  jfk.toString();
            System.out.format("integer for j : %d and Integer from x with base 2 : %d ", j,x);
            System.out.format( "%s",qwe);

            double qw = 22.22;
            double qe = 21.69;
            double qr = -20.12;
            double min = Math.min(qw,qe);
            double max = Math.max(qw,qe);
            double abs = Math.abs(qr);
            double exp = Math.exp(qe);
            double pow = Math.pow(qe,2);
            double log = Math.log(qe);

            System.out.format(" %e,%e,%e,%e,%e,%e,",min,max,abs,exp,pow,log);

        }


    }
