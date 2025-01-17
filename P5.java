import java.util.Scanner;		// Read keyboard input

public class P5
{
	private static final int POLYS = 4; // 4 Polygon objects
	private static P5Polygon [] a; // Array of polygons
	public static void main(String [] args)
	{
		char choice; // Repeat program
		double side; // Input Hexagon, Octagon
		double height; // Input Prisms
		String inputStr = null; // Input string
		Scanner scan = new Scanner(System.in);
		a = new P5Polygon[POLYS]; // Allocate 4 Polygon ref
		a[0] = new P5RegularHex(); // Instantiate objects
		a[1] = new P5HexPrism(1.1, 2.2);
		a[2] = new P5RegularOctagon();
		a[3] = new P5OctagonalPrism(3.3, 4.4);
		prt(); // Display objects
		do
		{
			System.out.print("\nEnter Hexagon and Octagon (side): ");
			side = scan.nextDouble();
			System.out.print("Enter Prism height: ");
			height = scan.nextDouble();
			a[0].setDim(side); // Reassign
			a[1].setDim(side, height);
			a[2].setDim(side);
			a[3].setDim(side, height);
			prt(); // Display objects
			System.out.print("\nWant to compute polygon figures (y/n)? ");
			inputStr = scan.next(); // Read, assign to string
			choice = inputStr.charAt(0); // Assign 1st character
		}while (choice != 'n' && choice != 'N'); // Loop until n or N
	}
	public static void prt()
	{
		int i;
		for(i = 0; i < POLYS; ++i)
			if(i%2 == 0)
			{
				System.out.print( a[i] + " has an area:");
				System.out.printf("\t%.3f \n", a[i].area());
				System.out.print( a[i] + " has a perimeter: ");
				System.out.printf("\t%.3f \n", a[i].perimeter());
			}
			else
			{
				System.out.print( a[i] + " has a surface area: ");
				System.out.printf("%.3f", a[i].area());
				System.out.printf(" and volume: %.3f\n",a[i].volume());
			}
	}
}
