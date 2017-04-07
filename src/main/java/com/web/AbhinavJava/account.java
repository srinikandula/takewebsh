class account{
        private int id;
        private String name;
        private double balance;
        
        public void setId(int num){
            id = num;
        }
        public void setName(String nam){
            name = nam;
        }
        public void setBalance(double bal){
            balance = bal;
        }
        public int getId(){
            return id;
        }
        public String getName(){
            return name;    
        }
        public double getBalance(){
            return balance;
        }
}