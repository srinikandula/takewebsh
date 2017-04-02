class SquareRoot{

public static void main(String[] args)
{	int i,squareroot;

	for(i=0;i<=100;i++){
		 squareroot= (int) Math.sqrt(i);
		if(i == squareroot*squareroot){
			System.out.println(i+"");
		}
	}
}

}