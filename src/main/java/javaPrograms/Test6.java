package javaPrograms;

class Shape
{
    int width,height;
    Shape()
    {
        this.width = 4;
        this.height = 6;
    }
}
class Triangle extends Shape
{
    public double area()
    {
        return width*height/2;
    }
}
class Rectangle extends Shape
{
    public int area()
    {
        return width*height;
    }
}
public class Test6
{
    public static void main(String args[])
    {
	    double triangle;
	    int rectangle;
	    Triangle tri = new Triangle();
	    Rectangle rect = new Rectangle();
	    triangle = tri.area();
	    System.out.println(triangle);
	    rectangle = rect.area();
	    System.out.println(rectangle);
    }
	
}
