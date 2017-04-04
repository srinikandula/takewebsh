class prime{
    public static void main(String[] args){
        int n = Integer.parseInt (args[0]);
        String c = "";
        if(n==1){
                c = "1 is nither prime nor composite";
            }
        else if(n==2){
                c = n + " is prime number";
        }
        for (int i=2 ; i<n; i++){
            if (n%i == 0){
                c = n + " is composite number";
                break;
            }
            else {
                c = n + " is prime number";

            }
        }
            System.out.println(c);
    }
}