public class P5OctagonalPrism extends P5RegularOctagon
{
	public P5OctagonalPrism(){ super(); }
	public P5OctagonalPrism(double s, double h){ super(s, h); }
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
