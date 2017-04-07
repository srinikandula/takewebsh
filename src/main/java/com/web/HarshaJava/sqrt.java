class sqrt{
    public static void main(String[] args){
        int count=0;
        int n = Integer.parseInt (args[0]);
        int m = Integer.parseInt (args[1]);


        for (int i=n; i<=m; i++){
            for (int j=1; j<=i; j++){
                if(j*j==i){
                    System.out.println(i);
                    count++;
                }
            }
        }
        System.out.println("Total Perfect Square roots between "+ n +" and "+ m +" : "+count);
    }
}