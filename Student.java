
package staticmethod;

class Student{  
    int rollno;  
    String name;  
    static String college = "ITS";  
      
    static void change(){  
    college = "CBIT";  
    }  
 
    Student(int r, String n){  
    rollno = r;  
    name = n;  
    }  
 
    void display ()
    {System.out.println(rollno+" "+name+" "+college);
    }  
 
   public static void main(String args[]){  
   Student.change();  
 
   Student s1 = new Student (111,"Kavita");  
   Student s2 = new Student (222,"Anu");  
   Student s3 = new Student (333,"Suraj");  
 
   s1.display();  
   s2.display();  
   s3.display();  
   }  
}  
