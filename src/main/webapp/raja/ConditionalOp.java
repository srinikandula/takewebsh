
class ConditionalOp{

public static void main (String[] args){

int a = 5;
int b = 10;
System.out.println("A = "+ a + ", B =" + b);
if(a==b){
	System.out.println("A is Equal to B");
} 
else{
	System.out.println("A is not Equal to B");
}



if(a>b){
	System.out.println("A is Greater than B");
} 
else{
	System.out.println("B is Greater than A");
}


if(a<b){
	System.out.println("B is Greater than A");
} 
else{
	System.out.println("A is Greater than B");
}


if(a==b){
	System.out.println("A is Equal to B");
} 
else{
	System.out.println("A is not Equal to B");
}


if((a == 5) && (b == 10)){
            System.out.println("A is 5 AND B is 10");
}

System.out.println("OR operator");
if((a == 5) || (b == 10)){
            System.out.println("A is 5 AND B is 10");
}

 for(int i=0;i<=2;i++){
System.out.println(i);
}

 for(int i=2;i>=0;i--){
System.out.println(i);
}

		int result;
        boolean condition = true;
        result = condition ? a : b;

        System.out.println(condition+ " value is "+result);

}
}