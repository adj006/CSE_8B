abstract class Bird
{
	protected int tweet;
	public Bird(){ tweet = 1; System.out.println(tweet); }
	public Bird(int b1){ tweet = b1; System.out.println(tweet); }
	public void song(){ System.out.println(tweet); }
}
public class Owl extends Bird
{
	protected int hoot;
	public Owl(){ hoot = 2; }
	public Owl(int h1){ super(h1); hoot =3; }
	public void song(){ System.out.println(hoot); }
	public void song(int s){ System.out.println(s); }
	public static void main(String[] args)
	{
		Bird b;
		Owl ow;
		b = new Bird();
		b.song();
		//b.song(3);
		ow = new Owl(4);
		ow.song();
		ow.song(6);
		b = new Owl();
		b.song();
	}
}
