/**
public class Test
{
public static void main(String[] args)
{
Demo myDemo = new Demo();
int x = 0;
for (int i = 0; i < 100; i++)
decrement(myDemo, x);
System.out.println("d is " + myDemo.d);
System.out.println("x is " + x);
}
public static void decrement(Demo de, int x)
{
de.d--;
x--;
}
}
class Demo
{
public int d;
public Demo(int c)
{
d = c;
}
public Demo()
{
d = 1;
}
}
**/

/**
public class Test
{
public static void main(String[] args)
{
int[] a = {1, 2};
copy(a[0], a[1]);
System.out.println("a[0] = " + a[0] + " a[1] = " + a[1]);
}
public static void copy(int n1, int n2)
{
n2 = n1;
}
}
**/

/**
public class Test
{
public static void main(String[] args)
{
int[] a = {1, 2};
copy(a);
System.out.println("a[0] = " + a[0] + " a[1] = " + a[1]);
}
public static void copy(int[] a)
{
a[1] = a[0];
}
}
**/

/**
public class Test
{
public static void main(String[] args)
{
T t = new T();
copy(t);
System.out.println("e1 = " + t.e1 + " e2 = " + t.e2);
}
public static void copy (T t)
{
t.e2 = t.e1;
}
}
class T
{
int e1 = 10;
int e2 = 20;
}
**/

/**
public class Test
{
public static void main(String[] args)
{
T t1 = new T(10);
T t2 = new T(20);
System.out.println("t1's i = " + t1.i + " and j = " + t1.j);
System.out.println("t2's i = " + t2.i + " and j = " + t2.j);
}
class T
{
static int i = 0;
int j;
T(int x)
{
i++;
j = x;
}
}
}
**/

import java.util.Date;

/**
public class Test
{
public static void main(String[] args)
{
Date date = null;
m1(date);
System.out.println(date);
}
public static void m1(Date date)
{
date = new Date();
}
}
**/

/**
public class Test
{
public static void main(String[] args)
{
Date date = new Date(1234567);
m1(date);
System.out.println(date.getTime());
}
public static void m1(Date date)
{
date = new Date(7654321);
}
}
**/

/**
public class Test
{
public static void main(String[] args)
{
Date date = new Date(1234567);
m1(date);
System.out.println(date.getTime());
}
public static void m1(Date date)
{
date.setTime(7654321);
}
}
**/

/**
public class Test
{
public static void main(String[] args)
{
Date date = new Date(1234567);
m1(date);
System.out.println(date.getTime());
}
public static void m1(Date date)
{
date = null;
}
}
**/

// 9.21
public class Test
{
  public static void main(String[] args)
  {
  	/**
    String s = "Java";
    StringBuffer buffer = new StringBuffer(s);
    change(s, buffer);
    System.out.println(s);
    System.out.println(buffer);
    **/

    //Number x = 5.0;
    //Integer x = new Integer(5);
    Number x = new Integer(5);
    //System.out.println(x.intValue());
    System.out.println(x.doubleValue());
    //System.out.println(x.compareTo(new Integer(8)));
    System.out.println((Double)x.compareTo(new Integer(8)));
  }
  /**
  private static void change(String s, StringBuffer buffer)
  {
    s = s + " and HTML";
    buffer.append(" and HTML");
  }
  **/
}
