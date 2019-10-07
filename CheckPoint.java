public class CheckPoint
{
public static void main(String[] args)
{
Demo d1 = new Demo(10);
Demo d2 = new Demo();
copy1(d1, d2);
System.out.println("After copy1: d1 = " + d1.d + " d2 = " + d2.d);
copy2(d1, d2);
System.out.println("After copy2: d1 = " + d1.d + " d2 = " + d2.d);
}
public static void copy1(Demo x, Demo y)
{
Demo temp = x;
x = y;
y = temp;
}
public static void copy2(Demo x, Demo y)
{
int temp = x.d;
x.d = y.d;
y.d = temp;
}
}
class Demo
{
int d;
Demo(int newD)
{
d = newD;
}
Demo()
{
}
}
