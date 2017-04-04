class CheckPrime
{
    public static void main(String args[]){
        int n = Integer.parseInt(args[0]);
        if(n==1){
         System.out.print("This is neither Prime Number nor Composite");      
        }
        if(n==2){
            System.out.print(" Prime Number");
        }
        for(int i=2; i<n; i++)
        {
            if(n%i == 0){
                    System.out.print("This is not a Prime Number");
                    break;
                }
            else{
                System.out.print("This is a Prime Number");
                break;
            }
        }
    }
}