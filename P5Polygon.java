/**
* P5Polygon() - No argument constructor, initialize side to one
* P5Polygon(double) - No argument constructor, initialize side to parameter
*
* toString() - Format and return class name
* getName() - Generates name of this class object and return as
* a String
* setDim(double) - Assign 1 dimension of a 2-D polygon (side)
* setDim(double,double) - Assign 2 dimensions of a 3-D polygion (side, height)
*
* perimeter() - Calculate perimeter of a polygon
* area() - Calculate area of a polygion
* volume() - Calculate volume of a polygion
**/

public abstract class P5Polygon
{
	protected double side, height; // The length of a side and height of a polygon
	
	public P5Polygon(){ side = 1; }	// No argument contructor
	public P5Polygon(double s){ side = s; }	// Constructor passing double
	public String toString()
	{
    return(getName() + "\t" + this.side + "side");
	}
	public String getName(){ return( this.getClass().getName() + ": "); }
	public void setDim(double s){ this.side = s; }
	public void setDim(double s, double h)
	{
		this.side = s;
		this.height = h;
	}
	public abstract double perimeter();//{ return(2*this.side + 2*this.height); }
	public abstract double area();//{ return(this.side*this.side); }
	public abstract double volume();//{ return(this.area*height); }
}
