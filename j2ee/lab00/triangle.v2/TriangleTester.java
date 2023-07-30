package pjava.lab00.triangle_v2;

public class TriangleTester {

    public static void main(String[] args) {

        Triangle t1 = new Triangle();
        Triangle t2 = null;
        Triangle t3 = new Triangle();
        
        try {
            t1.resize(10, 30, 30);
            t2 = new Triangle(3, 4, 5);
            t3.resize(10, 30, 50);
        }
        catch(Exception e) {
            System.out.println("" + e.getMessage() );
            //System.out.println("Traingle can not be formed from given data");
        }

        //test area and perimeter
        System.out.println("Area of t1: " + t1.area());
        System.out.println("Perimeter of t1: " + t1.perimeter());
        System.out.println("Area of t2: " + t2.area());
        System.out.println("Perimeter of t2: " + t2.perimeter());
        System.out.println("Area of t3: " + t3.area());
        System.out.println("Perimeter of t3: " + t3.perimeter());
    }

}
