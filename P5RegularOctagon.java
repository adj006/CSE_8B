public class P5RegularOctagon extends P5Polygon
{
	public P5RegularOctagon(){ super();/*this.side = 1;*/ }
	public P5RegularOctagon(double s){ super(s);/*this.side = s;*/ }
	public String toString(){ return(getName() + side); }
	public double perimeter(){ return(8*side); }
	public double area(){ return(2*(1 + Math.sqrt(2))*Math.pow(this.side, 2)); }
}
