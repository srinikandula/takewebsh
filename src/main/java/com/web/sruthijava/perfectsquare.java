class perfectsquare {
    public static void main(String[] args)
    {
        int a = 1;
        int b = 100;
       for(int i = a ; i <=b ; i++) {
           int num = i;
           int sqrt =(int) Math.sqrt(num);
               if (sqrt * sqrt == num) {
                     System.out.println(num);

            }
        }
    }
}

