public class Mid_Term
{
	/**
	private static int j = 1;
	static void fun (int k){j += k; fun(true);}
	static double fun (double x){return (x *= j);}
	static void fun(boolean b){System.out.println(!b);}
	**/

	/**
	private static int grade1 = 3;
	public static void prt(int grade2){System.out.println(grade1 += grade2);}
	public static int count(double g, int grade1){prt(grade1 + 2); return 0;}
	public static boolean count(int g)
	{
		if(g%3 < 2)	return true;
		return false;
	}
	**/

	/**
	static int [][] a = new int [2][4];
	static int funny(){int a = 2; fun(); return a;}
	static void fun(){/**c[1][1] = 1;**}
	**/

	/**
	private static int jan1[][] = {{1, 2}, {2, 3, 4}, {5, 6, 7}}, jan2[] = new int[4], jan4[][] = {{2, 2, 2}, {3, 3, 3}};
	private static int jan3[][] = jan1;
	public static void qz2(int a[][]){jan4[1][1] += 2;}
	public static int addMon(int a){System.out.println(jan1[3][2]); return 0;}
	public static void prt()
	{
		//int jan4[][] = {{2, 2, 2}, {3, 3, 3}};
		qz2(jan4);
		for(int i =0; i < jan3[i].length; ++i)
			for(int j = 0; j < jan3[i].length; ++j)
				System.out.println(jan3[i][j]);
		addMon(jan4[0][1]);
	}
	**/
	/**
	static int [] a = new int [4];
	static void fun(){/*c[1][1] = 1;*} // No memory allocated
	**/
	
	public static void main(String[] args)
	{
		/**
		int j = 2, k = 3, m = 3;
		do
			for(j = k = 4; j < 7; ++j)
				System.out.println(j++ + k % m);
		while(--m > 2);
		while(j/4 > 1)
		{
			System.out.println(j);
			switch(j%4)
			{
				case 1:
				case 2: System.out.println((j == 2 || j > 2));
								break;
				default: System.out.println(--j);
			}
		}
		**/

		/**
		int k = 4;
		double m = 2.2;
		fun(2);
		m = fun(m);
		System.out.println("j = " + j + "\nk = " + k + "\nm = " + m);
		**/

		/**
		//byte 4bites ;		/** bitten *
		//long quiz // ;			#1
		int first = 8;	/* FIRST quiz *
		switch(first % 6)
		{
			case 1: first -= 2; break;
			case 2: ++first;
			case 3: first -= 5; break;
		}
		System.out.println(first -= 2);
		**/

		/**
		final int MAX = 5;
		int a[] = {3, 5, 7};
		int grade2 = 1;
		double grade3 = 1.5;
		do
		{
			if(count(++grade2))
				System.out.println( (MAX > ++grade2 || false) );
			count(grade3, a[1]/3);
		}while(grade2 > MAX%4 && grade2 < MAX - 1);
		**/

		/**
		int i,j;
		int b[][], c[][] = {{2, 3}, {4, 5}};
		//System.out.println(b[0][1]);
		b = new int[2][3];
		a = c;
		//System.out.println(a[2][3]);
		funny();
		for(i = 0; i < c.length; ++i)
			for(j = c[i].length - 1; j >= 0; --j)
				System.out.println(c[i][j]);
		**/

		/**
		int i, j, jan5[] = new int[4];
		for(i = 0, j = 0; i < jan2.length; ++i)
			jan2[i] = i;
		prt();
		**/

		/**
		boolean b = true;
		int i = 1;
		//while(++i < 5)
			//System.out.println(i);
		do
			System.out.println(i + 1);
		while(++i < 4);
		**/

		/**
		int i = 2;
		switch(i)
		{
			case 1:
						i++;
						break;
			case 2:
						System.out.println(i);
			default:
						i--;
						break;
		}
		**/
		/**
		int i, j, k, tmp;
		int b[][], c[][] = {{2, 2}, {3, 3}}, d[][];
		b = new int[2][3];
		//System.out.println(d[0][1]); // No memory allocated yet
		d = c;
		for(i = 0; i < d.length; ++i)
			for(j = 0; j < d[i].length; ++j)
				d[i][j] += 2;
		//System.out.println(d[2][3]); // Index out of bounds exception
		fun();
		for(i = 0; i < a.length; ++i)
			a[i] = a.length - i;
		for(i = 0; i < a.length; ++i)
			for(j = a.length - 1; i < j; --j)
				if(a[j-1] > a[j])
				{
					tmp = a[j-1];
					a[j-1] = a[j];
					a[j] = tmp;
					for(k = 0; k < a.length; ++k)
					{
						if(k == i || k == j)
							System.out.print(a[k]);
						else
							System.out.print("*");
					}
					System.out.println();
				}
		**/

		/**
		int i = 0;
		String s = "2 B or not 2 B";
		String a[] = s.split(" ");
		System.out.println(s.charAt(2));
		for(i = 0; i < a.length; ++i)
			if(! a[i].equals(a[0]))
				System.out.println(a[i]);
		**/

		/**
		Age me = new Age();
		Age sneha = new Age();
		me.add(2);
		//me.year--;
		sneha.sub(me);
		System.out.println(me.getOld() + " " + sneha.getOld());
		**/

		/**
		Date myYr, feb;	// F
		myYr = new Date();	// G
		feb = new Date(2, 2013);	// H
		System.out.println(myYr.getMon() + "/" + myYr.getYr());	// I
		feb.leap();	// J
		System.out.println(feb.getMon() + "/" + feb.getYr());	// K
		**/
	}
}

/**
class Age
{
	private int year = 3;
	public void add(int y){year += y;}
	public void sub(Age a){year *= a.year - 3;}
	public int getOld(){return ++year;}
}
**/

/**
class Date
{
	private int month, year;
	public Date(){year = 1900; month = 1;}	// A
	public Date(int m, int y){year = y; month = m;}	// B
	public int getYr(){return year;}	// C
	public int getMon(){return month;}	// D
	public void leap(){year = year + month;}  // E
}
**/
