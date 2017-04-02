class UnaryOp{

public static void main(String[] args){

	int i = 0;
	int j =	5; 
	System.out.println("increment operator");
	for(i=0;i<5;i++){
		System.out.println(i);
	}

System.out.println("decrement operator");
	for(j=5;j>=0;j--){
		System.out.println(j);
	}

System.out.println("Unary Plus operator" + +i);	

System.out.println("Unary minus operator" + -i);	
}
}