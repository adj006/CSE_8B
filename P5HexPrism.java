/**
* P5HexPrism() - No argument constructor, initialize height to one
* P5HexPrism(s,h) - Overloaded constructor, initialize height to parameter
* toString() - Override, return a String with formatted dimensions of a
* hexagonal prism
* setDim(s,h) - Override, assign dimensions of a hexagonal prism
* area() - Override super class area, calculate area of a hexagonal prism
* volume() - Override - Calculate volume of a hexagonal prism
**/

public class P5HexPrism extends P5RegularHex
{
	public P5HexPrism(){ super(); }
	public P5HexPrism(double s, double h){ super(s, h); }
	/*{
		this.side = s;
		this.side = h;
	}*/
	public String toString()
	{
		return(getName() + "\t" + side + "x" + height);
	}
	public void setDim(double s, double h){ super(s, h); }
	public double area(){ return(2*super.area() + super.perimeter()*height); }
	public double volume(){ return(height*super.area()); }
}
