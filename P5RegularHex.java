/**
* P5RegularHex() - No argument constructor
* P5RegularHex(s) - Overloaded constructor, pass the side parameter to P5Polygon(s)
* toString() - Implement toString, format dimensions of a hexagon
* perimeter() - Override and implement super class perimeter
* area() - Implement super class area, calculate area of a hexagon
**/
public class P5RegularHex extends P5Polygon
{
	public P5RegularHex(){ super();/*this.side = 1;*/ }
	public P5RegularHex(double s){ super(s);/*this.side = s;*/ }
	public String toString(){ return(getName() + side); }
	public double perimeter(){ return(6*side); }
	public double area(){ return( (3.0*Math.pow(3, 0.5)*Math.pow(this.side, 2))/2.0 ); }
}
