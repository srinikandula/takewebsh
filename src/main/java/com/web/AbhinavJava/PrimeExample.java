class PrimeExample{
    public static void main(String args[]){
        int n = Integer.parseInt(args[0]);
        if(n==1){
            System.out.println("Given Number is GodKnows");
        }
        if(n==2){
            System.out.println("Given Number is prime");
        }
        for(int i=2;i<n;i++){
            if(n%i == 0){
                System.out.println("Given Number is not prime");
                break;
            }
            else{
                System.out.println("Given Number is prime");
                break;
            }    
        }
    }
}