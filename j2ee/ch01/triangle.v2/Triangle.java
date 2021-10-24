package pjava.ch03.triangle_v2;

public class Triangle {

    public Triangle() {
        try{
            this.resize(0,0,0);
        }
        catch(Exception e){ }
    }
    public Triangle(double a, double b, double c) throws InvalidData {
        this.resize(a,b,c);
    }

    public void resize(double new_a, double new_b, double new_c) 
                   throws InvalidData {
        double s = (new_a+new_b+new_c)/2;
        if ( ((s-new_a) * (s-new_b) * (s-new_c)) < 0 )
            throw new InvalidData("Error forming a triangle");            
        a = new_a;
        b = new_b;
        c = new_c;        
    }
       
    public double area() {
        double area, s;
        s = (a+b+c)/2;
        area = Math.sqrt(s *(s-a) * (s-b) * (s-c));
        return area;
    }
       
    public double perimeter() {
        double p;
        p = a+b+c;
        return p;
    }
    
    public double getA(){
        return a;
    }
    public double getB(){
        return b;
    }
    public double getC(){
        return c;
    }
        
    private double a;
    private double b;
    private double c;
    
}