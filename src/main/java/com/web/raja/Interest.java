import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by HOME on 4/7/2017.
 */
public final class Interest {
    public double calculate(double rate, long days, double amount){
        return amount*(rate/365*days);
    }

    public static long rate;
    private long type;


    public static long getRate(){
        return rate;
    }

    public static void setRate(long value) {
        rate = value;
    }

    public void setType(long value) {
        this.type = value;
    }

    public long getType() {
        return type;
    }

    public static void main(String[] args) {
        Interest calc = new Interest();
        Interest calc1 = new Interest();
        System.out.println("Interest" + calc.calculate(2,3,2));
        System.out.println("Rate from Class" + calc1.getRate());

        calc.setRate(4);
        calc.setType(5);


        System.out.println("Type from Obj1 " + calc.getType());
        System.out.println("Type from Obj2 " + calc1.getType());
        System.out.println("Rate from Class " + Interest.getRate() );

    }
}
