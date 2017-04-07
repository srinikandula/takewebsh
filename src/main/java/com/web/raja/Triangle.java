/**
 * Created by HOME on 4/6/2017.
 */
public class Triangle extends Figure {
    Triangle(double a, double b){
        super(a, b);
    }

    double area(){
        System.out.println("Area of triangle");
        return dim1*dim2/2;
    }
}
