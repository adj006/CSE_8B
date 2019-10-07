public class Ch9
{
  public static void main(String[] args)
  {
    /**
    //9.1
    String s1 = "Welcome to Java";
    String s2 = s1;
    String s3 = new String("Welcome to Java");
    String s4 = "Welcome to Java";
    System.out.println("Answer to a.: " + (s1 == s2));
    System.out.println("Answer to b.: " + (s2 == s3));
    System.out.println("Answer to c.: " + (s1.equals(s2)));
    System.out.println("Answer to d.: " + (s2.equals(s3)));
    System.out.println("Answer to e.: " + (s1.compareTo(s2)));
    System.out.println("Answer to f.: " + (s2.compareTo(s3)));
    System.out.println("Answer to g.: " + (s1 == s4));
    System.out.println("Answer to h.: " + (s1.charAt(0)));
    System.out.println("Answer to i.: " + (s1.indexOf('j')));
    System.out.println("Answer to j.: " + (s1.indexOf("to")));
    System.out.println("Answer to k.: " + (s1.lastIndexOf('a')));
    System.out.println("Answer to l.: " + (s1.lastIndexOf("o", 15)));
    System.out.println("Answer to m.: " + (s1.length()));
    System.out.println("Answer to n.: " + (s1.substring(5)));
    System.out.println("Answer to o.: " + (s1.substring(5, 11)));
    System.out.println("Answer to p.: " + (s1.startsWith("Wel")));
    System.out.println("Answer to q.: " + (s1.endsWith("Java")));
    System.out.println("Answer to r.: " + (s1.toLowerCase()));
    System.out.println("Answer to s.: " + (s1.toUpperCase()));
    System.out.println("Answer to t.: " + ("Welcome ".trim()));
    System.out.println("Answer to u.: " + (s1.replace('o', 'T')));
    System.out.println("Answer to v.: " + (s1.replaceAll("o", "T")));
    System.out.println("Answer to w.: " + (s1.replaceFirst("o", "T")));
    System.out.println("Answer to x.: " + (s1.toCharArray()));
    **/

    /**
    // 9.2
    String s1 = new String("new string");
    String s2 = new String("another new string");
    //String s3 = s1 * s2;
    String s3 = s1 + s2;
    s1 = s2;
    //s1 <= s2;
    s1.compareWith(s2);
    **/

/**
    // 9.20
    StringBuilder s1 = new StringBuilder("Java");
    StringBuilder s2 = new StringBuilder("HTML");
    System.out.println("Answer to a.: " + (s1.append(" is fun")));
    System.out.println("Answer to b.: " + (s1.append(s2)));
    System.out.println("Answer to c.: " + (s1.insert(2, "is fun")));
    System.out.println("Answer to d.: " + (s1.insert(1, s2)));
    System.out.println("Answer to e.: " + (s1.charAt(2)));
    System.out.println("Answer to f.: " + (s1.length()));
    System.out.println("Answer to g.: " + (s1.deleteCharAt(3)));
    System.out.println("Answer to h.: " + (s1.delete(1, 3)));
    System.out.println("Answer to i.: " + (s1.reverse()));
    System.out.println("Answer to j.: " + (s1.replace(1, 3, "Computer")));
    System.out.println("Answer to k.: " + (s1.substring(1, 3)));
    System.out.println("Answer to l.: " + (s1.substring(2)));
**/
  }
}
